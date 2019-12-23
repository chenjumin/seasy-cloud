FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG preferred_networks
ARG profiles_active
ARG eureka_security_uid
ARG eureka_security_pwd

WORKDIR /opt/seasy/seasy-cloud-eureka
COPY target/seasy-cloud-eureka/seasy-cloud-eureka .

ENV preferred_networks=$preferred_networks
ENV profiles_active=$profiles_active
ENV eureka_security_uid=$eureka_security_uid
ENV eureka_security_pwd=$eureka_security_pwd

EXPOSE 3001
CMD java -Xms512m -Xmx512m -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=utf-8 -jar seasy-cloud-eureka.jar
