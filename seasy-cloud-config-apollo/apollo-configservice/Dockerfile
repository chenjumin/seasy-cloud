FROM openjdk:8-jre
MAINTAINER seasy@163.com

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .

RUN mv /etc/apt/sources.list /etc/apt/sources.list.bak && \
    echo "deb http://mirrors.163.com/debian/ jessie main non-free contrib" >/etc/apt/sources.list && \
    echo "deb http://mirrors.163.com/debian/ jessie-proposed-updates main non-free contrib" >>/etc/apt/sources.list && \
    echo "deb-src http://mirrors.163.com/debian/ jessie main non-free contrib" >>/etc/apt/sources.list && \
    echo "deb-src http://mirrors.163.com/debian/ jessie-proposed-updates main non-free contrib" >>/etc/apt/sources.list
    
RUN chmod 777 scripts/startup.sh && \
  apt-get -y update && \
  apt-get install -y procps && \
  apt-get install -y vim-tiny

EXPOSE 3202
CMD ["scripts/startup.sh"]
