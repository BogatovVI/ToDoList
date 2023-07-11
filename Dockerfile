FROM gradle AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
EXPOSE 8080

WORKDIR /home/gradle/src
ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]