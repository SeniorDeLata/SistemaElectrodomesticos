FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/carrito-service-0.0.1.jar
COPY ${JAR_FILE} carrito-service-0.0.1.jar
ENTRYPOINT ["java", "-jar", "carrito-service-0.0.1.jar"]