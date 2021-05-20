FROM openjdk:8
ADD target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=container", "-Djava.security.egd=file:/dev/./urandom","-jar", "app.jar"]