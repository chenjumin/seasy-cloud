#!/bin/bash
SERVICE_NAME=apollo-configservice
LOG_DIR=/opt/logs/apollo/configservice
#LOG_DIR=D:\work\git\chenjumin\seasy-cloud\seasy-cloud-config-apollo\apollo-configservice\target\apollo-configservice\apollo-configservice
SERVER_PORT=3201

#preferred_networks=10.10.0
echo preferred_networks

## Create log directory if not existed because JDK 8+ won't do that
mkdir -p $LOG_DIR

## Adjust memory settings if necessary
export JAVA_OPTS="-Xms512m -Xmx512m -Xmn256m -Xss128k -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m -XX:SurvivorRatio=8"

########### The following is the same for configservice, adminservice, portal ###########
export JAVA_OPTS="$JAVA_OPTS -XX:ParallelGCThreads=4 -XX:MaxTenuringThreshold=9 -XX:+DisableExplicitGC -XX:+ScavengeBeforeFullGC -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+ExplicitGCInvokesConcurrent -XX:+HeapDumpOnOutOfMemoryError -XX:-OmitStackTraceInFastThrow -Duser.timezone=Asia/Shanghai -Dclient.encoding.override=UTF-8 -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom"

# DataSource URL USERNAME PASSWORD
if [ "$DS_URL"x != x ]
then
    export JAVA_OPTS="$JAVA_OPTS -Dspring.datasource.url=$DS_URL -Dspring.datasource.username=$DS_USERNAME -Dspring.datasource.password=$DS_PASSWORD"
fi

export JAVA_OPTS="$JAVA_OPTS -Dserver.port=$SERVER_PORT -Dlogging.file=$LOG_DIR/$SERVICE_NAME.log -XX:HeapDumpPath=$LOG_DIR/HeapDumpOnOutOfMemoryError/"

javaexe="$JAVA_HOME/bin/java"
version=$("$javaexe" -version 2>&1 | awk -F '"' '/version/ {print $2}')
version=$(echo "$version" | awk -F. '{printf("%03d%03d",$1,$2);}')

# now version is of format 009003 (9.3.x)
if [ $version -ge 011000 ]; then
    JAVA_OPTS="$JAVA_OPTS -Xlog:gc*:$LOG_DIR/gc.log:time,level,tags -Xlog:safepoint -Xlog:gc+heap=trace"
elif [ $version -ge 010000 ]; then
    JAVA_OPTS="$JAVA_OPTS -Xlog:gc*:$LOG_DIR/gc.log:time,level,tags -Xlog:safepoint -Xlog:gc+heap=trace"
elif [ $version -ge 009000 ]; then
    JAVA_OPTS="$JAVA_OPTS -Xlog:gc*:$LOG_DIR/gc.log:time,level,tags -Xlog:safepoint -Xlog:gc+heap=trace"
else
    JAVA_OPTS="$JAVA_OPTS -Xloggc:$LOG_DIR/gc.log -XX:+PrintGCDetails"
    JAVA_OPTS="$JAVA_OPTS -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=60 -XX:+CMSClassUnloadingEnabled -XX:+CMSParallelRemarkEnabled -XX:CMSFullGCsBeforeCompaction=9 -XX:+CMSClassUnloadingEnabled  -XX:+PrintGCDateStamps -XX:+PrintGCApplicationConcurrentTime -XX:+PrintHeapAtGC -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=5M"
fi

#echo $JAVA_OPTS

chmod a+x $SERVICE_NAME".jar"
./$SERVICE_NAME".jar" start

exit 0;
