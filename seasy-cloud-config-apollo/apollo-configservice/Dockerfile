FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .

#RUN mv /etc/apt/sources.list /etc/apt/sources.list.bak && \
#    echo "deb http://mirrors.163.com/debian/ jessie main" >/etc/apt/sources.list && \
#    echo "deb http://mirrors.163.com/debian/ jessie-proposed-updates main" >>/etc/apt/sources.list

RUN apt-get update && apt-get install -y procps && chmod 777 scripts/startup.sh

EXPOSE 3202
CMD ["scripts/startup.sh"]
