FROM maven:3.5-jdk-8-alpine as build
COPY calculator/src /home/app/src
COPY calculator/pom.xml /home/app
RUN mvn -f home/app/pom.xml clean install

FROM openjdk:8-jre-alpine
COPY --from=build /home/app/target/calculator-1.0-SNAPSHOT.jar /home/app/calculator.jar
CMD ["java","-jar", "/home/app/calculator.jar"]
