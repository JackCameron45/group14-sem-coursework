#FROM openjdk:latest
#COPY ./target/classes/com /tmp/com
#WORKDIR /tmp
#ENTRYPOINT ["java", "com.napier.semgroup14.MainProgram"]

FROM openjdk:latest
COPY ./target/SEMGroup14-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEMGroup14-1.0-SNAPSHOT-jar-with-dependencies.jar", "db:3306"]