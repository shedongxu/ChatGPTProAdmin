FROM maven:3.6.3-jdk-8-slim AS build

# 设置工作目录
WORKDIR /app

COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

# 指定基础镜像为Java 8
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

COPY target/ruoyi.jar /app

EXPOSE 80

CMD ["java", "-jar", "/app/ruoyi.jar"]





