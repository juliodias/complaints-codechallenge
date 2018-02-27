FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} service-registration.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-registration.jar"]