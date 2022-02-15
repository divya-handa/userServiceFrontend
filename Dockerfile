FROM amazoncorretto:11-alpine3.14

COPY target/user-service-frontend.jar /var/lib/service.jar

EXPOSE 8061

ENTRYPOINT ["java","-jar", "/var/lib/service.jar"]