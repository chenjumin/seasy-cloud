java -javaagent:/opt/seasy/seasy-cloud-userservice/agent/skywalking-agent.jar -Dskywalking.agent.service_name=userservice -Dskywalking.collector.backend_service=oap:11800 -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=utf-8 -jar seasy-cloud-userservice.jar
