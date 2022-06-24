FROM openjdk:11-jdk

VOLUME /tmp

ADD target/SWDP-CD-CI-0.0.1-SNAPSHOT.jar swdp-cd-ci.jar

ENTRYPOINT ["java", "-jar", "swdp-cd-ci.jar"]

EXPOSE 8081
