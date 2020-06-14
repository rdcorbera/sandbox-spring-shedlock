FROM openjdk:11.0.7-jre

COPY build/libs/jobs-0.0.1-SNAPSHOT.jar /usr/app/jobs.jar

WORKDIR /usr/app

CMD ["java", "-jar", "jobs.jar"]
