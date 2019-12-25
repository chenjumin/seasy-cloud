FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-portal
COPY target/apollo-portal/apollo-portal .

#RUN apt-get update && apt-get install -y procps
RUN chmod 777 startup.sh

EXPOSE 3203
CMD ["sh", "startup.sh"]
