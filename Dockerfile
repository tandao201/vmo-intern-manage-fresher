FROM openjdk:11-jdk-slim
WORKDIR /tmp
COPY target/manage_fresher1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]