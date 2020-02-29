FROM openjdk:slim
COPY build/libs/reactor-netty-redis-poc-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar
