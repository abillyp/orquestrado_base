# ===== Build (Maven + Java 25)
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app

# cache de deps primeiro (build mais rápido)
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# agora o código
COPY src ./src
RUN mvn -q -DskipTests package

# ===== Runtime (Java 25)
FROM eclipse-temurin:25-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# (opcional) documenta a porta, mas quem manda é o docker-compose
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
