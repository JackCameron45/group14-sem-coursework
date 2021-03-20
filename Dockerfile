FROM openjdk:latest
COPY ./target/semgroup14.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semgroup14.jar", "db:3306"]