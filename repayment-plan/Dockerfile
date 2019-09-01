FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR /usr/
COPY /target/repayment-app-0.0.1-SNAPSHOT.jar /usr/repayment-app.jar
ENTRYPOINT ["java","-jar","repayment-app.jar"]
