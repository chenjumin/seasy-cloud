#!/bin/bash
SERVICE_NAME=apollo-adminservice
LOG_DIR=/opt/logs

mkdir -p $LOG_DIR

## JAVA_OPTS
export JAVA_OPTS="-Xms512m -Xmx512m -Xmn256m -Xss128k -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m -XX:SurvivorRatio=8"
export JAVA_OPTS="$JAVA_OPTS -XX:ParallelGCThreads=4 -XX:MaxTenuringThreshold=9 -XX:+DisableExplicitGC -XX:+ScavengeBeforeFullGC -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+ExplicitGCInvokesConcurrent -XX:+HeapDumpOnOutOfMemoryError -XX:-OmitStackTraceInFastThrow -Duser.timezone=Asia/Shanghai -Dclient.encoding.override=UTF-8 -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom"
export JAVA_OPTS="$JAVA_OPTS -XX:HeapDumpPath=$LOG_DIR/HeapDumpOnOutOfMemoryError/"
export JAVA_OPTS="$JAVA_OPTS -Xloggc:$LOG_DIR/gc.log -XX:+PrintGCDetails"
export JAVA_OPTS="$JAVA_OPTS -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=60 -XX:+CMSClassUnloadingEnabled -XX:+CMSParallelRemarkEnabled -XX:CMSFullGCsBeforeCompaction=9 -XX:+CMSClassUnloadingEnabled  -XX:+PrintGCDateStamps -XX:+PrintGCApplicationConcurrentTime -XX:+PrintHeapAtGC -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=5M"

chmod a+x $SERVICE_NAME".jar"
java -jar $SERVICE_NAME".jar"
