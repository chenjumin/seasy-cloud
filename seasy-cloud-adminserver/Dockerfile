FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG eureka_server_address
ARG preferred_networks
ARG profiles_active
ARG eureka_security_uid
ARG eureka_security_pwd

WORKDIR /opt/seasy/seasy-cloud-adminserver
COPY target/seasy-cloud-adminserver/seasy-cloud-adminserver .

ENV eureka_server_address=$eureka_server_address
ENV preferred_networks=$preferred_networks
ENV profiles_active=$profiles_active
ENV eureka_security_uid=$eureka_security_uid
ENV eureka_security_pwd=$eureka_security_pwd

EXPOSE 3100
CMD java -Xms512m -Xmx512m -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=utf-8 -jar seasy-cloud-adminserver.jar
