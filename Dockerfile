#FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
FROM openjdk:17-jdk-slim-buster

#Create and Set base dir for project
ENV PROJECT_HOME /usr/share/poc
RUN mkdir $PROJECT_HOME

#Copy App Jar file
COPY build/libs/ecard-0.0.1-SNAPSHOT.jar $PROJECT_HOME/

#Copy resources files
ENV RESOURCES src/main/resources

ENTRYPOINT ["java", "-jar","-XX:MaxRAMPercentage=70.0","/usr/share/poc/ecard-0.0.1-SNAPSHOT.jar"]
