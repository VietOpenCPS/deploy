#!/bin/bash
# bachkhoabk47@gmail.com

DIR="`pwd`"
DIR_CURR=$DIR/docker-compose

############### Installing Docker on Centos 7 ########################
# Update installed package
yum update -y
# Run script for installing Docker
curl -fsSL https://get.docker.com/ | sh
# Start Docker service
service docker start
# Run Docker automatically while reboot
chkconfig docker on
# Check it
docker run hello-world

############## Installing Docker-compose on Centos 7 ###############
# Download and run script for installing docker-compose
wget https://github.com/docker/compose/releases/download/1.7.1/docker-compose-`uname -s`-`uname -m` -O /usr/local/bin/docker-compose
# Chown permission
chmod +x /usr/local/bin/docker-compose

##########################################################################

######################## DEPLOYING OPENCPS APPLICATION ##################
yum -y install svn
svn export https://github.com/VietOpenCPS/deploy.git/trunk/Dockerize-OpenCPS/docker-compose

echo $DIR_CURR

if [ -d "$DIR_CURR" ]; then
  sh -c `cd $DIR_CURR && docker-compose -f docker-compose.yml up -d`
  echo "Done! You can open browser with the address: localhost:8080 for testing application. Thanks"
else
  echo "docker-compose directory not found, please check it again or contact to author"
fi
