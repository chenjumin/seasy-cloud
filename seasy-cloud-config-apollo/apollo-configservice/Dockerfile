FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .

RUN apt-get update && apt-get install -y procps && chmod 777 startup.sh

EXPOSE 3201
CMD ["startup.sh"]
