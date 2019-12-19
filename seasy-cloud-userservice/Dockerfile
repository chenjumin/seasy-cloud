FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/seasy-cloud-userservice

COPY target/seasy-cloud-userservice/seasy-cloud-userservice .

EXPOSE 4001

ENTRYPOINT -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=utf-8 -javaagent:agent/skywalking-agent.jar -Dskywalking.agent.service_name=userservice -Dskywalking.collector.backend_service=skywalking-oap:11800 -jar seasy-cloud-userservice.jar
