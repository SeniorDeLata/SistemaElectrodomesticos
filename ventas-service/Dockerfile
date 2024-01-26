FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/ventas-service-0.0.1.jar
COPY ${JAR_FILE} ventas-service-0.0.1.jar
ENTRYPOINT ["java", "-jar", "ventas-service-0.0.1.jar"]