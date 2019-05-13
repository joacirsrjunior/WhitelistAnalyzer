FROM openjdk:8-jre-alpine
EXPOSE 8080
ADD /target/*.jar /opt/api-whitelist.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/api-whitelist.jar