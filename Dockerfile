# ======================================================================
# Stage 1: Build the Spring Boot application
# ======================================================================

FROM eclipse-temurin:25-jdk-alpine AS build

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# ======================================================================
# Stage 2: Run the application
# ======================================================================

FROM eclipse-temurin:25-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar ClipzConnectApplication.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ClipzConnectApplication.jar"]