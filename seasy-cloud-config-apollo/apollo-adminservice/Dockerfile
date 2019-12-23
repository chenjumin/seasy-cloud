FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-adminservice

COPY target/apollo-adminservice/apollo-adminservice .

EXPOSE 3202

CMD ["sh", "scripts/startup.sh"]
