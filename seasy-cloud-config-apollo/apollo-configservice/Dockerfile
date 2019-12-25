FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG preferred_networks

#ENV REFRESH_DATE 2019-12-25
ENV preferred_networks=$preferred_networks

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .

#RUN apt-get update && apt-get install -y procps
RUN chmod 777 startup.sh

EXPOSE 3201
CMD ["sh", "startup.sh"]
