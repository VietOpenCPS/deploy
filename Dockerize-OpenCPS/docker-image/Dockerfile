# Author: VietOpenCPS
#
# Build: docker build -t opencps/liferay-all-in-one:0.01 .
# Run: docker run -d -p 8080:8080 --name vietopencps opencps/liferay-all-in-one:0.01
#

FROM java:7-jdk
MAINTAINER Tan Nguyen Van "tan.nv@netnam.vn"

RUN wget -q http://172.17.0.1/server.tar.gz -O /server.tar.gz \
    && tar -zxvf /server.tar.gz \
    && rm /server.tar.gz

COPY config/* /server/

WORKDIR /server/

EXPOSE 8080

# docker entrypoint
COPY docker-entrypoint.sh /
ENTRYPOINT ["/docker-entrypoint.sh"]

CMD ["start-tomcat"]
