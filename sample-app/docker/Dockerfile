FROM anapsix/alpine-java:8_server-jre_unlimited

LABEL maintainer="Can Bezmen <canbezmen@gmail.com>"

ENV PROFILE=docker

ADD ./build/libs/*.jar app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=${PROFILE}", "-Xmx128m", "-Duser.timezone=UTC", "app.jar"]
