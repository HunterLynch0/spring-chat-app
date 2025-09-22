FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY . .

# Build
RUN ./mvnw -DskipTests package

# Render will set $PORT; run on it
EXPOSE 8080
CMD ["sh", "-c", "java -jar target/*.jar --server.port=$PORT"]
