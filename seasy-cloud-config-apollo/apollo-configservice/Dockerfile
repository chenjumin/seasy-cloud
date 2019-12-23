FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG preferred_networks

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .

ENV preferred_networks=$preferred_networks

EXPOSE 3202
CMD ["scripts/startup.sh"]
