# Usa Java 21 JDK base
FROM eclipse-temurin:21-jdk-alpine

# Directory di lavoro
WORKDIR /app

# Copia il JAR costruito da Maven o Gradle
COPY rest-api-web/target/rest-api-web-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta della tua app Spring Boot
EXPOSE 8080

# Esegue l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]