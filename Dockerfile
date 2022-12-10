FROM eclipse-temurin:11-jre

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} DemoApp.jar

ENTRYPOINT ["java", "-jar", "/DemoApp.jar"]