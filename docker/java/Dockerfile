FROM openjdk:8-jdk

EXPOSE 8090
RUN mkdir -p /opt/app
WORKDIR /opt/app

ARG JAR_PATH

COPY $JAR_PATH /opt/app

CMD java $JVM_OPTIONS -jar $JAR_NAME
