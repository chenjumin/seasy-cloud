FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/seasy-cloud-userservice

COPY target/seasy-cloud-userservice/seasy-cloud-userservice .
# RUN chmod 777 docker_run.sh

EXPOSE 4001

CMD ["sh", "docker_run.sh"]
