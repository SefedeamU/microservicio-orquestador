# Microservicio Orquestador

Este proyecto es un microservicio para la orquestación de usuarios, roles, proyectos, tareas y comentarios utilizando **Spring Boot**.

## Estructura del Proyecto

- `src/main/java/com/example/microservicio_orquestador/`
    - `controller/`
        - `OrchestratorController.java`: Controlador principal que maneja las solicitudes HTTP.
    - `dto/`
        - `RegisterDto.java`, `LoginDto.java`, `RolDto.java`, `ProyectoDto.java`, `UsuarioDto.java`, `UsuarioProyectoDto.java`, `TareaDto.java`, `CommentDto.java`: Definición de los DTOs utilizados en las solicitudes y respuestas.
    - `service/`
        - `OrchestratorService.java`: Lógica de negocio para la orquestación de los diferentes microservicios.
    - `config/`
        - `WebClientConfig.java`: Configuración del cliente web para realizar llamadas a otros microservicios.

- `src/main/resources/`
    - `application.properties`: Archivo de configuración de la aplicación.

## Configuración

1. Clonar el repositorio.
2. Configurar las URLs de los microservicios en el archivo `application.properties`.
3. Instalar las dependencias y compilar el proyecto:

   ```bash
   mvn clean install
   ```

4. Ejecutar la aplicación:

   ```bash
   mvn spring-boot:run
   ```

## Endpoints

### Usuarios:
- **POST /orchestrator/users**: Crear un nuevo usuario.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "email": "string",
        "password": "string"
      }
      ```
- **POST /orchestrator/users/login**: Iniciar sesión de un usuario.
    - **Body**:
      ```json
      {
        "email": "string",
        "password": "string"
      }
      ```
- **GET /orchestrator/users**: Obtener todos los usuarios.
    - **Headers**:
      ```json
      {
        "Authorization": "Bearer token"
      }
      ```
- **GET /orchestrator/users/{id}**: Obtener un usuario por ID.
- **PUT /orchestrator/users/{id}**: Actualizar un usuario por ID.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "email": "string",
        "password": "string"
      }
      ```
- **DELETE /orchestrator/users/{id}**: Eliminar un usuario por ID.

### Roles:
- **POST /orchestrator/roles**: Crear un nuevo rol.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "descripcion": "string"
      }
      ```
- **GET /orchestrator/roles**: Obtener todos los roles.
    - **Headers**:
      ```json
      {
        "Authorization": "Bearer token"
      }
      ```
- **GET /orchestrator/roles/{id}**: Obtener un rol por ID.
- **PUT /orchestrator/roles/{id}**: Actualizar un rol por ID.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "descripcion": "string"
      }
      ```
- **DELETE /orchestrator/roles/{id}**: Eliminar un rol por ID.

### Proyectos:
- **POST /orchestrator/proyectos**: Crear un nuevo proyecto.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "descripcion": "string",
        "fechaInicio": "string",
        "fechaFin": "string"
      }
      ```
    - **Params**:
      ```json
      {
        "usuarioId": "number"
      }
      ```
- **GET /orchestrator/proyectos**: Obtener proyectos por ID de usuario.
    - **Params**:
      ```json
      {
        "usuarioId": "number"
      }
      ```
- **GET /orchestrator/proyectos/{id}**: Obtener un proyecto por ID.
- **PUT /orchestrator/proyectos/{id}**: Actualizar un proyecto por ID.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "descripcion": "string",
        "fechaInicio": "string",
        "fechaFin": "string"
      }
      ```
- **DELETE /orchestrator/proyectos/{id}**: Eliminar un proyecto por ID.
- **GET /orchestrator/proyectos/{id}/usuarios**: Obtener usuarios por ID de proyecto.
- **GET /orchestrator/proyectos/{id}/tareas**: Obtener tareas por ID de proyecto.

### Usuarios\_Proyectos:
- **POST /orchestrator/usuarios_proyectos**: Crear una nueva relación usuario-proyecto.
    - **Body**:
      ```json
      {
        "usuarioId": "number",
        "proyectoId": "number",
        "rol": "string"
      }
      ```
- **GET /orchestrator/usuarios_proyectos**: Obtener todas las relaciones usuario-proyecto.
- **GET /orchestrator/usuarios_proyectos/{id}**: Obtener una relación usuario-proyecto por ID.
- **PUT /orchestrator/usuarios_proyectos/{id}**: Actualizar una relación usuario-proyecto por ID.
    - **Body**:
      ```json
      {
        "usuarioId": "number",
        "proyectoId": "number",
        "rol": "string"
      }
      ```
- **DELETE /orchestrator/usuarios_proyectos/{id}**: Eliminar una relación usuario-proyecto por ID.

### Tareas:
- **POST /orchestrator/tasks**: Crear una nueva tarea.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "descripcion": "string",
        "estado": "string",
        "proyectoId": "number",
        "responsableId": "number",
        "fechaVencimiento": "string"
      }
      ```
- **PUT /orchestrator/tasks/{taskId}**: Actualizar una tarea por ID.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "descripcion": "string",
        "estado": "string",
        "proyectoId": "number",
        "responsableId": "number",
        "fechaVencimiento": "string"
      }
      ```
- **DELETE /orchestrator/tasks/{taskId}**: Eliminar una tarea por ID.
- **GET /orchestrator/tasks/{taskId}**: Obtener una tarea por ID.
- **GET /orchestrator/tasks**: Obtener todas las tareas con paginación.
    - **Params**:
      ```json
      {
        "skip": "number",
        "limit": "number"
      }
      ```

### Comentarios:
- **POST /orchestrator/comments**: Crear un nuevo comentario.
    - **Body**:
      ```json
      {
        "contenido": "string",
        "tareaId": "number",
        "usuarioId": "number"
      }
      ```

- **GET /orchestrator/comments/{commentId}**: Obtener un comentario por ID.

## Contribuir

1. Hacer un fork del repositorio.
2. Crear una nueva rama:

   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```

3. Realizar los cambios necesarios y hacer commit:

   ```bash
   git commit -am 'Añadir nueva funcionalidad'
   ```

4. Hacer push a la rama:

   ```bash
   git push origin feature/nueva-funcionalidad
   ```

5. Crear un Pull Request.

## Puerto
La aplicación se ejecuta en el puerto `8081`. Asegúrate de que este puerto esté disponible en tu máquina.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia **MIT**.