# Stage 1: Build
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar los archivos de proyecto al contenedor
COPY pom.xml ./pom.xml
COPY src ./src

# Construir la aplicación sin ejecutar las pruebas
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Copiar el JAR generado en la etapa de build
COPY --from=build /app/target/sistema-encuestas-backend-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
