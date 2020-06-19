# Build ispmap
FROM maven:3.6.3-jdk-8 as build
MAINTAINER rappet.de
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package

# Create jre container and copy jar
FROM openjdk:8-jre-alpine
EXPOSE 8080
COPY --from=build /build/target/*.jar ispmap.jar

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

CMD exec java -jar ./ispmap.jar