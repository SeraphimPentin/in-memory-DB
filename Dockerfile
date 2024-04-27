#FROM openjdk:21
#VOLUME /tmp
#ARG JAR_FILE=out/artifacts/in_memory_DB_jar.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:17-jdk
WORKDIR /app
COPY out/artifacts/demo/in-memory-db.jar /app/in-memory-db.jar
CMD ["java", "-jar", "/app/in-memory-DB.jar"]