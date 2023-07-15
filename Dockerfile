FROM openjdk:11-jdk-slim
WORKDIR /tmp
COPY /tmp/target/manage_fresher-1.0.0.jar manage_fresher-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/manage_fresher-1.0.0.jar"]