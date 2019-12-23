FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-portal
COPY target/apollo-portal/apollo-portal .
RUN chmod 777 startup.sh

EXPOSE 3203
CMD ["startup.sh"]
