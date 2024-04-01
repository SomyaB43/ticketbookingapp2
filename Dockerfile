# FROM eclipse-temurin:17-jdk-alpine
FROM eclipse-temurin:8-jdk-alpine
VOLUME /tmp
COPY target/ticketbookingapp.war app.war
ENTRYPOINT ["java","-jar","/app.war"]
