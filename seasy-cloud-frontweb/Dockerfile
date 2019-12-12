FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/seasy-cloud-frontweb

COPY target/seasy-cloud-frontweb/seasy-cloud-frontweb .
RUN chmod 777 docker_run.sh

EXPOSE 4002

CMD ["sh", "docker_run.sh"]
