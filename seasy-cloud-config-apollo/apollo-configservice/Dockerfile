FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .

EXPOSE 3202
CMD ["sh", "scripts/startup.sh"]
