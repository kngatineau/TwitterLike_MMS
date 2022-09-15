FROM openjdk:17-oracle
LABEL maintainer="kngatineau@gmail.com"
ARG JAR_FILE=target/TwitterLike_MMS-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]