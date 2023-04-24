
# 指定基础镜像为Java 8
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

COPY target/ruoyi.jar /app/ruoyi.jar

EXPOSE 80

CMD ["java", "-jar", "/app/ruoyi.jar"]





