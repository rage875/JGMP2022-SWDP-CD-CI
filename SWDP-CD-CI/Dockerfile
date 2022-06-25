FROM openjdk:11-jdk

ARG LABEL_GROUP=business-services
ARG LABEL_ID=swdp-cd-ci
ARG JAR_FILE=target/*.jar
ARG JAR_NAME_TO_RUN=swdp-cd-ci.jar

LABEL ${LABEL_GROUP}="${LABEL_ID}}"

VOLUME /tmp
EXPOSE 8081

COPY ${JAR_FILE} ${JAR_NAME_TO_RUN}
ENTRYPOINT ["java", "-jar", "/swdp-cd-ci.jar"]
