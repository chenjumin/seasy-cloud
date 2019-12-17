#!/bin/bash

#pull source code
cd /opt/projects/seasy-cloud
git pull origin master

#build images
cd /opt/projects/seasy-cloud/seasy-cloud-eureka
./build.sh

cd /opt/projects/seasy-cloud/seasy-cloud-adminserver
./build.sh

cd /opt/projects/seasy-cloud/seasy-cloud-userservice
./build.sh

cd /opt/projects/seasy-cloud/seasy-cloud-frontweb
./build.sh

#push images
docker push 192.168.134.142/seasy/seasy-cloud-eureka:0.0.1-SNAPSHOT
docker push 192.168.134.142/seasy/seasy-cloud-adminserver:0.0.1-SNAPSHOT
docker push 192.168.134.142/seasy/seasy-cloud-userservice:0.0.1-SNAPSHOT
docker push 192.168.134.142/seasy/seasy-cloud-frontweb:0.0.1-SNAPSHOT
