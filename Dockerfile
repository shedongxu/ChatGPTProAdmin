FROM maven:3.6.3-jdk-8-slim AS build

# 设置工作目录
WORKDIR /app

COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package


FROM openjdk:8-jre-slim
# 设置工作目录
WORKDIR /app
EXPOSE 80
COPY --from=build /app/target/ruoyi.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]




