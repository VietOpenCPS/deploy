# Author: Nguyen Van Tan
#
# Build: docker build -t opencps/liferay-all-in-one:0.01 .
# Run: docker run -d -p 8080:8080 --name vietopencps opencps/liferay-all-in-one:0.01
# Reference: http://davidx.me/2014/07/21/create-a-mariadb-service-on-centos-with-docker/

FROM centos:7 
MAINTAINER Nguyen Van Tan <bachkhoabk47@gmail.com> 


COPY container-files/etc/yum.repos.d/* /etc/yum.repos.d/
COPY config/* /server/

RUN yum update -y && \
yum install -y wget && \
wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/7u80-b15/jre-7u80-linux-x64.rpm" && \
yum localinstall -y /jre-7u80-linux-x64.rpm && \
rm -f /jre-7u80-linux-x64.rpm && \
yum clean all

################################################### MYSQL
RUN \
    yum update -y && \
    yum install -y epel-release && \
    yum install -y MariaDB-server hostname net-tools pwgen && \
    yum clean all && \
    rm -rf /var/lib/mysql/*


#################################################################
RUN wget -q http://172.17.0.1/server.tar.gz -O /server.tar.gz \
    && tar -xvf /server.tar.gz \
    && rm /server.tar.gz

# Define working directory. 
WORKDIR /server

EXPOSE 8080
EXPOSE 3306

# docker entrypoint
COPY docker-entrypoint.sh /
ENTRYPOINT ["/docker-entrypoint.sh"]

# Define default command. 
#CMD ["bash"]
CMD ["start-tomcat"]

