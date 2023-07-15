# Use a base image with Java 16 pre-installed
FROM adoptopenjdk:16-jre-hotspot

# Set the working directory in the container to /app
WORKDIR /app

# Copy the Spring Boot application JAR file to the container
COPY target/spring-app.jar /app

# Expose port 8080, which is the default port for Spring Boot applications
EXPOSE 8080

# Set the command to run when the container is started
CMD ["java", "-jar", "spring-app.jar"]