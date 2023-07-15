
#
# Build stage
#
FROM maven:3.8.3-openjdk-11 AS build
WORKDIR /app
COPY . /app/

RUN mv target/*.jar target/app.jar
#
# Package stage
#
FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=build /app/target/app.jar ./
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]