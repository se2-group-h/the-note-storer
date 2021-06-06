# build for staging
FROM maven:3.6.3-openjdk-11
MAINTAINER SE2 Group H
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true
# run for staging
FROM openjdk:11.0.10
WORKDIR /app
COPY --from=0 /build/target/backend-0.25b.jar /app/
COPY entrypoint.sh /app/
RUN chmod +x ./entrypoint.sh
ENV PORT=8081
EXPOSE $PORT
ENTRYPOINT ["./entrypoint.sh"]
