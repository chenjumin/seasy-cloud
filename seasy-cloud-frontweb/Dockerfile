FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG eureka_server_address
ARG preferred_networks
ARG profiles_active
ARG eureka_security_uid
ARG eureka_security_pwd
ARG apollo_meta
ARG apollo_env=dev

WORKDIR /opt/seasy/seasy-cloud-frontweb
COPY target/seasy-cloud-frontweb/seasy-cloud-frontweb .

ENV eureka_server_address=$eureka_server_address
ENV preferred_networks=$preferred_networks
ENV profiles_active=$profiles_active
ENV eureka_security_uid=$eureka_security_uid
ENV eureka_security_pwd=$eureka_security_pwd
ENV apollo_meta=$apollo_meta
ENV apollo_env=$apollo_env

EXPOSE 4002
CMD ["sh", "-c", "java -Denv=$apollo_env -javaagent:/opt/seasy/seasy-cloud-frontweb/agent/skywalking-agent.jar -Dskywalking.agent.service_name=frontweb -Dskywalking.collector.backend_service=oap:11800 -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=utf-8 -jar seasy-cloud-frontweb.jar"]
