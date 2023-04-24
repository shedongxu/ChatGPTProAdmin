
# 指定基础镜像为Java 8
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

EXPOSE 80

CMD ["java", "-jar", "target/ruoyi.jar"]





