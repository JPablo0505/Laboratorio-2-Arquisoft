#Construccion
FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
#Empaquetado
From openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/lab2-arqui lab2-arqui
EXPOSE 8080
ENTRYPOINT ["java","-jar","lab2-arqui"]