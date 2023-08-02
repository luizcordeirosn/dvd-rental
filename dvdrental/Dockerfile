FROM adoptopenjdk:11-jre-hotspot

WORKDIR /dvdrental

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

ARG PROPERTIES_FILE=*.properties
COPY ${PROPERTIES_FILE} application.properties

EXPOSE 8082

#ENTRYPOINT ["java","-jar","/dvdrental/application.jar"]