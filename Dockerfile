# Use a base image with Java 16 installed
FROM adoptopenjdk:16-jre-hotspot

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/app.jar /app

# Run the command to start the Spring Boot application
CMD ["java", "-jar", "app.jar"]