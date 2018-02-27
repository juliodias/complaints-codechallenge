FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/api-gateway.jar"]