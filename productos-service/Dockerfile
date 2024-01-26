FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/productos-service-0.0.1.jar
COPY ${JAR_FILE} productos-service-0.0.1.jar
ENTRYPOINT ["java", "-jar", "productos-service-0.0.1.jar"]