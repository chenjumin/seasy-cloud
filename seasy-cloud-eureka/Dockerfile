FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/seasy-cloud-eureka

COPY target/seasy-cloud-eureka/seasy-cloud-eureka .
# RUN chmod 777 docker_run.sh

EXPOSE 3001

CMD ["sh", "docker_run.sh"]
