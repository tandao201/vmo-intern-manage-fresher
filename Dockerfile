# Use a base image with Java 16 installed
FROM adoptopenjdk:16-jre-hotspot
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080