FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/app.jar
EXPOSE 8000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/share/app.jar"]

