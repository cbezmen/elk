FROM adoptopenjdk/openjdk11:alpine-jre

LABEL maintainer="Can Bezmen <canbezmen@gmail.com>"

ENV PROFILE=docker

ADD ./target/*.jar app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=${PROFILE}", "-Xmx128m", "-Duser.timezone=UTC", "app.jar"]
