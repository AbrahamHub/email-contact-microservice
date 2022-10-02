FROM maven:latest AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

FROM eclipse-temurin:17-jdk

ARG JAR_FILE=SpringMailSending-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","SpringMailSending-0.0.1-SNAPSHOT.jar"]
