FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .
RUN chmod 777 scripts/startup.sh && apt-get update -y && apt-get install -y procps

EXPOSE 3202
CMD ["scripts/startup.sh"]
