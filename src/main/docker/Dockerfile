FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9006
ADD docker-practice.jar app.jar
# 为了缩短 Tomcat 的启动时间，添加 java.security.egd 的系统属性指向 /dev/urandom 作为 ENTRYPOINT
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx64m", "-Xms64m", "-jar", "/app.jar"]