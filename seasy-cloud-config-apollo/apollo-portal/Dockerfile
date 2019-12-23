FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-portal

COPY target/apollo-portal/apollo-portal .

EXPOSE 3203

CMD ["sh", "scripts/startup.sh"]
