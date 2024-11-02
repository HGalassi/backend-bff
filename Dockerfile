# Use a imagem base do Eclipse Temurin JDK 21
FROM eclipse-temurin:21-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR para o contêiner
COPY target/backend-bff-0.0.1-SNAPSHOT.jar backend-bff.jar

# Define as variáveis de ambiente
ENV AWS_ROLE_ARN=${AWS_ROLE_ARN}
ENV AWS_ACCESS_KEY_ID=${AWS_ACCESS_KEY_ID}
ENV AWS_SECRET_ACCESS_KEY=${AWS_SECRET_ACCESS_KEY}
ENV AWS_REGION=sa-east-1

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "backend-bff.jar"]