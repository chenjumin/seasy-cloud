FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/seasy-cloud-adminserver

COPY target/seasy-cloud-adminserver/seasy-cloud-adminserver .
RUN chmod 777 docker_run.sh

EXPOSE 3100

CMD ["sh", "docker_run.sh"]
