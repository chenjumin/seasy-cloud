FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/seasy-cloud-frontweb

COPY target/seasy-cloud-frontweb/seasy-cloud-frontweb .
RUN chmod 777 docker_run.sh

EXPOSE 4002

ENTRYPOINT -Xms512m -Xmx512m -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=utf-8 -javaagent:agent/skywalking-agent.jar -Dskywalking.agent.service_name=frontweb -Dskywalking.collector.backend_service=skywalking-oap:11800 -jar seasy-cloud-frontweb.jar
