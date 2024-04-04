# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS todo_backend_builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create a minimal JRE image
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=todo_backend_builder /app/target/tanver-todo-app-0.0.1-SNAPSHOT.jar tanver-todo-app-0.0.1-SNAPSHOT.jar

EXPOSE 8081

# Specify the default command to run on startup
CMD ["java", "-jar", "tanver-todo-app-0.0.1-SNAPSHOT.jar"]