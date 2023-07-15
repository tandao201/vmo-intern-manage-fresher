FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/*.jar manage_fresher-1.0.0.jar
ENTRYPOINT ["java","-jar","/manage_fresher-1.0.0.jar.jar"]
EXPOSE 8080