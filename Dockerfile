# Usar una imagen base de Java
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado en el directorio de trabajo
COPY target/microservicio_orquestador-0.0.1-SNAPSHOT.jar app.jar

# Copiar el archivo JAR generado en el directorio de trabajo
COPY target/microservicio_orquestador-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOI
NT ["java", "-jar", "app.jar"]