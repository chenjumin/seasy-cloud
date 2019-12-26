#!/bin/bash

#pull source code
cd /opt/projects/seasy-cloud
git pull origin master

:<<!
cd /opt/projects/seasy-cloud/seasy-cloud-eureka
chmod 777 build.sh
./build.sh

docker push 192.168.134.142/seasy/seasy-cloud-eureka:0.0.1-SNAPSHOT
!

:<<!
cd /opt/projects/seasy-cloud/seasy-cloud-adminserver
chmod 777 build.sh
./build.sh

cd /opt/projects/seasy-cloud/seasy-cloud-userservice
chmod 777 build.sh
./build.sh

cd /opt/projects/seasy-cloud/seasy-cloud-frontweb
chmod 777 build.sh
./build.sh

docker push 192.168.134.142/seasy/seasy-cloud-adminserver:0.0.1-SNAPSHOT
docker push 192.168.134.142/seasy/seasy-cloud-userservice:0.0.1-SNAPSHOT
docker push 192.168.134.142/seasy/seasy-cloud-frontweb:0.0.1-SNAPSHOT
!

:<<!
cd /opt/projects/seasy-cloud/seasy-cloud-config-apollo/apollo-configservice
chmod 777 build.sh
./build.sh

docker push 192.168.134.142/seasy/apollo-configservice:1.5.1

cd /opt/projects/seasy-cloud/seasy-cloud-config-apollo/apollo-adminservice
chmod 777 build.sh
./build.sh

docker push 192.168.134.142/seasy/apollo-adminservice:1.5.1
!

cd /opt/projects/seasy-cloud/seasy-cloud-config-apollo/apollo-portal
chmod 777 build.sh
./build.sh

docker push 192.168.134.142/seasy/apollo-portal:1.5.1

