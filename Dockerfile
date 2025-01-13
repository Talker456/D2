FROM openjdk:17-jdk

COPY build/libs/Demo2-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]