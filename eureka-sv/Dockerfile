FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/eureka-sv-0.0.1.jar
COPY ${JAR_FILE} eureka-sv-0.0.1.jar
ENTRYPOINT ["java", "-jar", "eureka-sv-0.0.1.jar"]