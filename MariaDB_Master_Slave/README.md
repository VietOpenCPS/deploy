# Triển khai MariaDB Master-Slave
###Môi trường cài đặt:
- Database version: MariaDB 10.1 (Stable)
- OS: Centos 7.2
- 2 server:
  + Master: 192.168.1.181
  + Slave : 192.168.1.182

Triển khai Master-Slave với cấu hình đơn giản bằng:
- Triển khai bằng script.
- Triển khai theo hướng dẫn

####*(dùng cách 1 hoặc dùng cách 2, nếu bạn dùng Script thì không cần cài đặt theo hướng dẫn và ngược lại)*

###1 - Sử dụng Script để cài Master-Slave tự động
Download từng Script Master.sh, Slave.sh về node tương ứng và chạy bằng câu lệnh sh
ví dụ: 
Trên Master Server:
```
sh Master.sh
```
Slave Server:
```
sh Slave.sh
```
*Lưu ý: Sau khi trên Master Server chạy xong thì mới bắt đầu chạy Slave.sh trên Slave Server.*

###2 - Hướng dẫn cài đặt Master-Slave thủ công
####Trên cả 2 Server:
- Tạo Repository cho MariaDB:
```
vi /etc/yum.repos.d/MariaDB.repo
[mariadb]
name = MariaDB
baseurl = http://yum.mariadb.org/10.1/centos7-amd64
gpgkey=http://yum.mariadb.org/RPM-GPG-KEY-MariaDB
gpgcheck=1
```
- Save lại và cài đặt MariaDB bằng lệnh YUM:
```
yum -y install MariaDB-server MariaDB-client
```
- Khởi động MariaDB
```
systemctl start mysql
systemctl enable mysql
```
- Sau khi đã cài đặt xong MariaDB-server. Chay mysql_secure_installation để đặt mật khẩu cho Root và loại bỏ một số nguy cơ bảo mật.
```
mysql_secure_installation
```
####Trên Master Server:
- Down initdata của OpenCPS.
```
cd /tmp && wget https://github.com/VietOpenCPS/deploy/blob/master/MariaDB_Master_Slave/opencps.sql && tar -zxvf opencps.tar.gz
```
- Tạo database OpenCPS và import dữ liệu vào
```
mysql -uroot -p        ← dang nhap vao MariaDB
```
- Sau khi đăng nhập Database, ta tiếp tục chạy các câu lệnh sau để tạo Database OpenCPS và import dữ liệu vào:
```
create database opencps;
source /tmp/opencps.sql;
```
- Sửa file /etc/my.cnf.d/server.cnf
```
vi /etc/my.cnf.d/server.cnf
[mysqld]
server_id=1
log_error=/var/log/mysql.log
log-bin=master-bin
replicate-do-db=opencps
innodb_file_per_table=1
```
- Tạo soft link /etc/my.cnf như sau:
```
ln /etc/my.cnf.d/server.cnf /etc/my.cnf
```
- Khởi động lại MariaDB:
```
systemctl restart mysql
```
- Sau khi Đăng nhập vào MariaDB, tạo tài khoản Slave và gán quyền cần thiết cho tà khoản này
```
Mariadb [(none)]> grant replication slave on *.* to slave@'%' identified by 'slavepasswd';
Mariadb [(none)]> flush privileges;
Mariadb [(none)]> flush privileges with read lock;
Mariadb [(none)]> show master status;
```

Câu lệnh show Master Status sẽ hiển thị  binary lock MariaDB Master đang sử dụng và position của nó

*Lưu ý: Câu lệnh flush privilges with read lock sẽ lock db và sẽ không cho phép insert, update, delete db (nhằm mục đích giữ nguyên log position để chuyển sang Slave và đảm bảo việc dữ liệu không bị sai lệch giữa Master và Slave).*

- Export dữ liệu trên Database OpenCPS ra thành file .sql
```
mysqldump -uroot -p opencps > forslave.sql
```
(hoặc có thể lấy file initdata opencps.sql ở trên vì ta vẫn chưa thay đổi dữ liệu gì)

- đăng nhập Database trên Master:
```
mysql -uroot -p
```
- Sau khi đăng nhập vào Database, tiếp tục gõ câu lệnh sau:
```
unlock tables;
```
- Copy file forslave.sql (hoặc opencps.sql) sang bên Slave Server:
```
scp forslave.sql > root@192.168.10.182:/tmp/
```
- Add database service vào firewall
```
firewall-cmd --add-service=mysql
firewall-cmd --add-service=mysql --permanent
firewall-cmd –reload
```
####Cấu hình trên Slave Server:
- Đăng nhập vào MariaDB, tạo db opencps và tài khoản slave.
```
Mysql -uroot -p
Mariadb [(none)]> create database opencps;
Mariadb [(none)]> grant all privileges on opencps.* to 'slave'@'localhost' with grant option;
Mariadb [(none)]> flush privileges;
```
- Import dữ liệu từ file nhận từ Master Server:
```
mysql -uroot -p opencps < /tmp/forslave.sql
```
- Sửa file /etc/my.cnf.d/server.cnf
```
vi /etc/my.cnf.d/server.cnf
	[mysqld]
	log-error=/var/log/mysql.log
	log-bin=slave-bin
	server-id=2
	relay-log=slave-relay-bin
	innodb_file_per_table=1
	replicate-do-db=opencps
```
- Tạo soft link /etc/my.cnf như sau:
```
ln /etc/my.cnf.d/server.cnf /etc/my.cnf
```
- Khởi động lại MariaDB trên Slave:
```
systemctl restart mysql
```
- Đăng nhập vào MariaDB và cấu hình kêt nối tới Master Database:
```
mysql -uroot -p
MariaDB [(none)]> CHANGE MASTER TO
	MASTER_HOST='192.168.1.181',
	MASTER_USER='slave',
	MASTER_PASSWORD='slavepasswd',          ← Password của tài khoản slave trên Master
	MASTER_PORT=3306,
	MASTER_LOG_FILE='master-bin.000001';
	MASTER_LOG_POS=314,
	MASTER_CONNECT_RETRY=10;
```
- Khởi động đồng bộ trên Slave và kiểm tra xem hệ thống có hoạt động không:
```
MariaDB [(none)]> START SLAVE;
MariaDB [(none)]> SHOW SLAVE STATUS\G;
```
Nếu như thế này thì hệ thống đã chạy chuẩn xác
```
          Slave_IO_State	   : Waiting for the Master to send event
        	    Master_Host    : 192.168.1.181	
              Master_User	   : slave
	           Master_Port	   : 3306
          Master_Log_File	   : mysql-bin.000001
           Read_Master_Log_Pos : 314
		…
		… 
```
###Kiểm tra###
- Insert, Update dữ liệu vào database opencps trên Master.
- Show Master Status và Show Slave Status\G
- Kiểm tra các thông số Master_log_file, Read_Master_Log_Pos, nếu giống nhau thì hệ thống hoạt động tốt.
- Kiểm tra trên Slave xem các Insert, Update chạy trên Master được pull về Slave hay chưa.
