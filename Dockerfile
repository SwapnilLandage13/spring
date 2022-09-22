FROM openjdk:11
EXPOSE 8080
ADD target/SpringBoot.jar SpringBoot.jar
ENTRYPOINT ["java","-jar","/SpringBoot.jar"]