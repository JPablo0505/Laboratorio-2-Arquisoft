# Construcción
FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Empaquetado
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar lab2-arqui.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "lab2-arqui.jar"]
