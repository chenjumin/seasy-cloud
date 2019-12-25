FROM openjdk:8-jre
MAINTAINER seasy@163.com

ENV REFRESH_DATE 2019-12-25

WORKDIR /opt/seasy/apollo-configservice
COPY target/apollo-configservice/apollo-configservice .

#RUN apt-get update && apt-get install -y procps
#RUN chmod 777 startup.sh

EXPOSE 3201
#CMD ["sh", "startup.sh"]
CMD java -jar apollo-configservice.jar
