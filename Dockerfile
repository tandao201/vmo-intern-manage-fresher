# Use a base image with Java 16 pre-installed
FROM openjdk:11-jdk-slim

COPY --from=build /target/manage_fresher-1.0.0.jar manage_fresher.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","manage_fresher.jar"]