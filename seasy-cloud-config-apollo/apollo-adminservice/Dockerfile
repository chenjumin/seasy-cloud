FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG preferred_networks

WORKDIR /opt/seasy/apollo-adminservice
COPY target/apollo-adminservice/apollo-adminservice .

RUN apt-get update && apt-get install -y procps && chmod 777 scripts/startup.sh

ENV preferred_networks=$preferred_networks

EXPOSE 3202
CMD ["scripts/startup.sh"]
