# -------- STAGE 1: BUILD --------
FROM gradle:8.7-jdk17 AS build

WORKDIR /app

# Copia arquivos de build primeiro (melhora cache)
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle

RUN gradle dependencies --no-daemon || true

# Copia o restante do projeto
COPY . .

RUN gradle clean bootJar --no-daemon

# -------- STAGE 2: RUNTIME --------
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Define valor padrão para FILES_PATH
ENV FILES_PATH=/app/files

# Cria diretório para os arquivos
RUN mkdir -p /app/files

# Copia o jar gerado
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]