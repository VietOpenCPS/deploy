echo '####################################'
echo '####### INSTALL MARIADB 10.1 #######'
echo '####################################'

#TAO REPOSITORY MariaDB.repo
touch /etc/yum.repos.d/MariaDB.repo
echo '[mariadb]' >> /etc/yum.repos.d/MariaDB.repo
echo 'name = MariaDB' >> /etc/yum.repos.d/MariaDB.repo
echo 'baseurl = http://yum.mariadb.org/10.1/centos7-amd64/' >>/etc/yum.repos.d/MariaDB.repo
echo 'gpgkey=https://yum.mariadb.org/RPM-GPG-KEY-MariaDB' >> /etc/yum.repos.d/MariaDB.repo
echo 'gpgcheck=1' >> /etc/yum.repos.d/MariaDB.repo

yum clean all
yum makecache

#CAI DAT MariaDB Server
yum install MariaDB-server MariaDB-client -y

pkg1=$(rpm -qa| grep MariaDB-server)
if [[ "$pkg1" == *"MariaDB-server"*  ]];then
systemctl start mysql
chkconfig --add /etc/init.d/mysql

echo ''
#DAT PASSWORD ROOT CHO MariaDB
echo "Khoi tao Root password cho Database"
echo "==========================================="
unset password
export password=$(date +%s | sha256sum | base64 | head -c 12 ; echo)
mysql -u root -e "UPDATE mysql.user SET Password=PASSWORD('$password') WHERE User='root'; flush privileges;"
mysql -u root -p$password -e "DELETE FROM mysql.user WHERE User='';"
mysql -u root -p$password -e "DELETE FROM mysql.user WHERE User='root' AND Host NOT IN ('localhost', '127.0.0.1', '::1');"
mysql -u root -p$password -e "DROP DATABASE IF EXISTS test;"
mysql -u root -p$password -e "DELETE FROM mysql.db WHERE Db='test' OR Db='test\\_%';"
mysql -u root -p$password -e "FLUSH PRIVILEGES;"
echo "** DONE! **"
echo "==========================================="

echo ''
#Edit /etc/my.cnf.d/server.cnf
echo "Cau hinh Database Slave"
echo "==========================================="
mkdir /var/log/mysql
sed -i '/# this is only for the mysqld standalone daemon/d' /etc/my.cnf.d/server.cnf
sed -i "/mysqld/ a\replicate-do-db=opencps" /etc/my.cnf.d/server.cnf
mysql -u root -p$password -e "create database opencps";
sed -i '/mysqld/ a\server_id=1' /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\log-bin=master-bin' /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\log_error=/var/log/mysql/mysql.log' /etc/my.cnf.d/server.cnf
ln -s /etc/my.cnf.d/server.cnf /etc/my.cnf > /dev/null 2>&1
echo "** DONE! **"
echo "==========================================="

#Import du lieu vao db opencps
echo "Import database OPENCPS"
echo "==========================================="
pkg2=$(rpm -qa| grep wget)
if [[ "$pkg2" == *"wget"*  ]];then
        echo 'Wget package... OK!' 
else
        echo 'Installing Wget...'; yum -y install wget > /dev/null; echo " Done!"
fi
wget https://github.com/VietOpenCPS/deploy/raw/master/MariaDB_Master_Slave/opencps.tar.gz -P /tmp/ && cd /tmp/ && tar zxvf opencps.tar.gz >/dev/null 2>&1
mysql -uroot -p$password opencps < /tmp/opencps.sql
rm -rf /tmp/opencps.*
systemctl restart mysql
echo "** DONE! **"
echo "==========================================="

echo ''
echo "Tao tai khoan Slave cho Database"
echo "==========================================="
read -s -p "Please enter your Slave Password: " passslave
mysql -u root -p$password -e "grant replication slave on *.* to 'slave'@'%' identified by '$passslave';"
mysql -u root -p$password -e "flush privileges;"
echo ''
echo "** DONE! ** "
echo "==========================================="

#Tao cau hinh cho Slave lay ve
echo ''
echo "Cau hinh dong bo giua Master va Slave"
echo "==========================================="
export ipmaster=$(hostname -I)
echo "change master to master_host='"$ipmaster"'," > /tmp/changemaster.sql
echo "master_user='"slave"'," >> /tmp/changemaster.sql
echo "master_password='"$passslave"'," >> /tmp/changemaster.sql
echo "master_port=3306," >> /tmp/changemaster
master_log_file=$(mysql -uroot -p$password -s -e "select variable_value from information_schema.global_status where variable_name='Binlog_snapshot_file';"| awk '{print $1}';)
echo "master_log_file='"$master_log_file"'," >> /tmp/changemaster.sql
master_log_pos=$(mysql -uroot -p$password -s -e "select variable_value from information_schema.global_status where variable_name='BINLOG_SNAPSHOT_POSITION';"| awk '{print $1}';)
echo "master_log_pos="$master_log_pos"," >> /tmp/changemaster.sql
echo "master_connect_retry=10;" >> /tmp/changemaster.sql
echo '** DONE! **'
echo "==========================================="

echo ''
echo '----------------Ket Qua-------------------'
echo 'Cong viec Scipt nay da hoan thanh: '
echo '- Cai Dat MariaDB Server                                  DONE!'
echo '- Tao va Import du lieu vao Database opencps trong CSDL   DONE!'
echo '- Mat khau Root db: '$password
echo '- User/Pass Slave:  slave/'$passslave
else
        echo 'There are something wrong with Install MariaDB-Server, please try again later'
fi
