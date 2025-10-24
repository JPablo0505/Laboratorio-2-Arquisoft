FROM openjdk:17
EXPOSE 8080
ADD target/lab2-arqui.jar lab2-arqui.jar
ENTRYPOINT ["java","-jar","/lab2-arqui.jar"]