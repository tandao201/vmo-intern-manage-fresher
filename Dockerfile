FROM openjdk:16-slim
VOLUME /tmp
COPY target/*.jar manage_fresher-1.0.0.jar
ENTRYPOINT ["java","-jar","/manage_fresher-1.0.0.jar"]
EXPOSE 8080