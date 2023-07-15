# Package stage
#
FROM adoptopenjdk:16-jdk-hotspot
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]