FROM openjdk:8u151-jre-slim
COPY target/sqs-demoserver-1.0-SNAPSHOT.jar /server/
RUN chmod +x /server/sqs-demoserver-1.0-SNAPSHOT.jar
EXPOSE 8080

ENTRYPOINT ["/server/sqs-demoserver-1.0-SNAPSHOT.jar"]