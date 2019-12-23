FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .
RUN chmod 777 startup.sh

EXPOSE 3202
CMD ["startup.sh"]
