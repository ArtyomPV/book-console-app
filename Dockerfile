FROM openjdk:19-jdk-slim

COPY target/book-console-app-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "app.jar"]