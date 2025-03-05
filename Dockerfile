# ---------- Stage 1: Build the JAR ----------
FROM maven:3.8.7-eclipse-temurin-17-jdk-alpine AS build
WORKDIR /app

# Copy only the pom.xml first (for efficient caching of dependencies)
COPY pom.xml .
RUN mvn dependency:go-offline

# Now copy the rest of your source code
COPY src ./src

# Build the JAR (skip tests if you want faster builds)
RUN mvn clean package -DskipTests

# ---------- Stage 2: Create the final image ----------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 if you need it for local/Render usage
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
