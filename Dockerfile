### BUILDER IMAGE ###
FROM openjdk:8-alpine AS build
  
# Setup
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./

# Resolve Maven dependencies
RUN ./mvnw -B dependency:resolve-plugins dependency:resolve

# Copy remaining source files and build
COPY . .
RUN ./mvnw -DskipTests clean package



### RUNNER IMAGE ###
FROM openjdk:8-jre-alpine AS run

# Setup
WORKDIR /app

# Copy build artifact and run
COPY --from=build /app/target/ddd-0.0.1-SNAPSHOT.jar ./app.jar
CMD java -jar /app/app.jar



### TESTING IMAGE ###
FROM build AS test

# Run tests
CMD ./mvnw test
