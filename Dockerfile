FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springcassandra.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springcassandra.jar"]