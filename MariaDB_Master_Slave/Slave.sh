	`echo '####################################'
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
mysql -u root -p$password -e "create database opencps";             
sed -i "/mysqld/ a\replicate-do-db=opencps" /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\innodb_file_per_table=1' /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\read-only=1' /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\max_allowed_packet=64M' /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\relay-log=slave-relay-bin' /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\server_id=2' /etc/my.cnf.d/server.cnf
#sed -i '/mysqld/ a\log-slave-updates' /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\log-bin=slave-bin' /etc/my.cnf.d/server.cnf
sed -i '/mysqld/ a\log_error=/var/log/mysql/mysql.log' /etc/my.cnf.d/server.cnf
ln -s /etc/my.cnf.d/server.cnf /etc/my.cnf >/dev/null 2>&1
echo "** DONE! **"
echo "==========================================="

echo ''
#Import du lieu vao db opencps
echo "Import database OPENCPS"
echo "==========================================="
pkg1=$(rpm -qa| grep wget)
if [[ "$pkg1" == *"wget"*  ]];then
        echo 'Wget package... OK!'
else
        echo 'Installing Wget...'; yum -y install wget > /dev/null; echo " Done!"
fi

wget https://github.com/VietOpenCPS/deploy/raw/master/MariaDB_Master_Slave/opencps.tar.gz -P /tmp/ && cd /tmp/ && tar zxvf opencps.tar.gz
mysql -uroot -p$password opencps < /tmp/opencps.sql
rm -rf /tmp/opencps.*
systemctl restart mysql
echo "** DONE! **"
echo "==========================================="

echo ''
echo "Tao tai khoan Slave cho Database"
echo "==========================================="
read -s -p "Please enter your Slave Password: " passslave
mysql -u root -p$password -e "grant replication slave on *.* to 'slave'@'localhost' identified by '$passslave'; flush privileges;"
echo ''
echo "** DONE! ** "
echo "==========================================="

echo ''
echo "Cau hinh dong bo giua Master va Slave"
echo "==========================================="
cd /tmp && check=$(ls changemaster.sql 2>/dev/null)
until [[ "$check" == *"changemaster"* ]]; do
read -p "Please input your Master's IP: " ipmaster
if echo "$ipmaster" | egrep -E '[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}' >/dev/null 2>&1
then
    VALID_IP_ADDRESS="$(echo $ipmaster | awk -F'.' '$1 <=255 && $2 <= 255 && $3 <= 255 && $4 <= 255')"
    if [ -z "$VALID_IP_ADDRESS" ]
    then
        echo "====The IP address wasn't valid; octets must be less than 256===="
    else
        touch /tmp/scp
        echo 'scp -o "StrictHostKeyChecking=no" -q root@'$ipmaster':/tmp/changemaster.sql /tmp/changemaster.sql' > /tmp/scp
	echo "=Please input your Master's Root Password (System Password, not DB Password)="
	sh /tmp/scp >/dev/null 2>&1 && rm -rf /tmp/scp && cd /tmp
        cd /tmp/ && check=$(ls changemaster.sql 2>/dev/null)
        if [[ "$check" == *"changemaster"*  ]];then
        mysql -uroot -p$password -e "source changemaster.sql;" && rm -rf /tmp/changemaster.sql >/dev/null 2>&1
        else
            echo "====This IP is not your Master DB's IP Address===="
        fi
    fi
else
    echo "====The IP address was malformed===="
fi
done
echo "** DONE! **"
echo "==========================================="

echo ''
echo "Khoi dong dong bo giua Master va Slave"
echo "==========================================="
mysql -uroot -p$password -e "start slave;"
echo "** DONE! **"
echo "==========================================="

echo ''
echo '----------------Ket Qua-------------------'
echo '- Tao Database OpenCPS trong CSDL	DONE!'
echo '- Cau hinh dong bo voi Master		DONE!'
echo '- Mat khau Root Database: '$password
echo '- User/Pass user Slave: slave/'$passslave
else
        echo 'There are something wrong with network, please try again later'
fi
