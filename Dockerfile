# Use a base image with Java 16 pre-installed
FROM adoptopenjdk:16-jre-hotspot

# Set the working directory in the container to /app
WORKDIR /api-fresher-manager

# Copy the Spring Boot application JAR file to the container
COPY /api-fresher-manager/target/api-fresher-manager.jar /api-fresher-manager

# Expose port 8080, which is the default port for Spring Boot applications
EXPOSE 8080

# Set the command to run when the container is started
CMD ["java", "-jar", "api-fresher-manager.jar"]