FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG preferred_networks
ARG apollo_datasource_config_url
ARG apollo_datasource_username
ARG apollo_datasource_password

ENV preferred_networks=$preferred_networks
ENV apollo_datasource_config_url=$apollo_datasource_config_url
ENV apollo_datasource_username=$apollo_datasource_username
ENV apollo_datasource_password=$apollo_datasource_password

WORKDIR /opt/seasy/apollo-adminservice
COPY target/apollo-adminservice/apollo-adminservice .

#RUN apt-get update && apt-get install -y procps
RUN chmod 777 startup.sh

EXPOSE 3202
CMD ["sh", "startup.sh"]
