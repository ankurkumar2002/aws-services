
# Base image (Java environment)
FROM openjdk:17-jdk-slim

# Working directory inside container
WORKDIR /app

# Copy jar file into container
COPY target/user-service.jar app.jar

# Expose application port
EXPOSE 8080

# Command to run app
ENTRYPOINT ["java", "-jar", "app.jar"]
