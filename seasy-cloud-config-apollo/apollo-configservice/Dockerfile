FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG preferred_networks

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .

RUN apt-get update && apt-get install -y procps && chmod 777 scripts/startup.sh

ENV preferred_networks=$preferred_networks

EXPOSE 3201
CMD ["scripts/startup.sh"]
