# Tracing Example
```shell
mvn clean install

cd <example path>
mvn jetty:run -Ddb_usr=<your_db_username> -Ddb_pwd=<your_db_password> -javaagent:target/agent/opentracing-agent.jar=sys:target/agent/opentracing-agent-rules-java-web-servlet-filter.jar,sys:target/agent/cxf-opentracing-agent-rules.jar,sys:target/agent/javax.ws.rs-api.jar
```