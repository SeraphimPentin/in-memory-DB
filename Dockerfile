FROM openjdk:17-jdk
WORKDIR /app
COPY out/artifacts/demo/in-memory-db.jar /app/in-memory-db.jar
CMD ["java", "-jar", "/app/in-memory-db.jar"]