FROM openjdk:8
EXPOSE 9095
VOLUME /tmp
ADD build/libs/open-fda-api-0.0.1.jar /app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]