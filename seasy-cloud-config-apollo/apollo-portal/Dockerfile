FROM openjdk:8-jre
MAINTAINER seasy@163.com

ARG apollo_datasource_portal_url
ARG apollo_datasource_username
ARG apollo_datasource_password

ENV apollo_datasource_portal_url=$apollo_datasource_portal_url
ENV apollo_datasource_username=$apollo_datasource_username
ENV apollo_datasource_password=$apollo_datasource_password

WORKDIR /opt/seasy/apollo-portal
COPY target/apollo-portal/apollo-portal .

#RUN apt-get update && apt-get install -y procps
RUN chmod 777 startup.sh

EXPOSE 3203
CMD ["sh", "startup.sh"]
