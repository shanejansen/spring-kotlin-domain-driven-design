FROM openjdk:8-alpine

# Setup
WORKDIR /app
COPY . .

CMD ./mvnw -DskipTests clean package && java -agentlib:jdwp=transport=dt_socket,address=5005,suspend=n,server=y -Dcom.sun.management.jmxremote.rmi.port=9090 -Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=9090 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.local.only=false -Djava.rmi.server.hostname=localhost -jar /app/target/ddd-0.0.1-SNAPSHOT.jar
