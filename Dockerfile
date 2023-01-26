# syntax=docker/dockerfile:1

#FROM openjdk:8-jre-alpine
FROM adoptopenjdk/openjdk11:latest

#COPY app-0.0.1-SNAPSHOT.jar /app.war

CMD ["./mvnw", "spring-boot:run"]