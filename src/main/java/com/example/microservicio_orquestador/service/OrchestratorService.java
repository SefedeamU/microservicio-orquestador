package com.example.microservicio_orquestador.service;

import com.example.microservicio_orquestador.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OrchestratorService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${microservicio.usuarios.url}")
    private String usuariosUrl;

    @Value("${microservicio.proyectos.url}")
    private String proyectosUrl;

    @Value("${microservicio.tareas.url}")
    private String tareasUrl;

    // Usuarios
    public RegisterResponseDto createUser(RegisterDto registerDto) {
        return webClientBuilder.build()
                .post()
                .uri(usuariosUrl + "/users")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(registerDto)
                .retrieve()
                .bodyToMono(RegisterResponseDto.class)
                .block();
    }

    public LoginResponseDto loginUser(LoginDto loginDto) {
        return webClientBuilder.build()
                .post()
                .uri(usuariosUrl + "/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(loginDto)
                .retrieve()
                .bodyToMono(LoginResponseDto.class)
                .block();
    }

    public List<RegisterDto> getAllUsers(String token) {
        return webClientBuilder.build()
                .get()
                .uri(usuariosUrl + "/users")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(RegisterDto.class)
                .collectList()
                .block();
    }

    public RegisterDto getUserById(String id) {
        return webClientBuilder.build()
                .get()
                .uri(usuariosUrl + "/users/{id}", id)
                .retrieve()
                .bodyToMono(RegisterDto.class)
                .block();
    }

    public RegisterDto updateUser(String id, RegisterDto registerDto) {
        return webClientBuilder.build()
                .put()
                .uri(usuariosUrl + "/users/{id}", id)
                .bodyValue(registerDto)
                .retrieve()
                .bodyToMono(RegisterDto.class)
                .block();
    }

    public void deleteUser(String id) {
        webClientBuilder.build()
                .delete()
                .uri(usuariosUrl + "/users/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    // Roles
    public RolDto createRole(RolDto rolDto) {
        return webClientBuilder.build()
                .post()
                .uri(usuariosUrl + "/roles")
                .bodyValue(rolDto)
                .retrieve()
                .bodyToMono(RolDto.class)
                .block();
    }

    public List<RolDto> getAllRoles(String token) {
        return webClientBuilder.build()
                .get()
                .uri(usuariosUrl + "/roles")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToFlux(RolDto.class)
                .collectList()
                .block();
    }

    public RolDto getRoleById(String id) {
        return webClientBuilder.build()
                .get()
                .uri(usuariosUrl + "/roles/{id}", id)
                .retrieve()
                .bodyToMono(RolDto.class)
                .block();
    }

    public RolDto updateRole(String id, RolDto rolDto) {
        return webClientBuilder.build()
                .put()
                .uri(usuariosUrl + "/roles/{id}", id)
                .bodyValue(rolDto)
                .retrieve()
                .bodyToMono(RolDto.class)
                .block();
    }

    public void deleteRole(String id) {
        webClientBuilder.build()
                .delete()
                .uri(usuariosUrl + "/roles/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    // Proyectos
    public ProyectoDto createProyecto(ProyectoDto proyectoDto, Long usuarioId) {
        return webClientBuilder.build()
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path(proyectosUrl + "/proyectos")
                        .queryParam("usuarioId", usuarioId)
                        .build())
                .bodyValue(proyectoDto)
                .retrieve()
                .bodyToMono(ProyectoDto.class)
                .block();
    }

    public List<ProyectoDto> getProyectosByUsuarioId(Long usuarioId) {
        return webClientBuilder.build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(proyectosUrl + "/proyectos")
                        .queryParam("usuarioId", usuarioId)
                        .build())
                .retrieve()
                .bodyToFlux(ProyectoDto.class)
                .collectList()
                .block();
    }

    public ProyectoDto getProyectoById(Long id) {
        return webClientBuilder.build()
                .get()
                .uri(proyectosUrl + "/proyectos/{id}", id)
                .retrieve()
                .bodyToMono(ProyectoDto.class)
                .block();
    }

    public ProyectoDto updateProyecto(Long id, ProyectoDto proyectoDto) {
        return webClientBuilder.build()
                .put()
                .uri(proyectosUrl + "/proyectos/{id}", id)
                .bodyValue(proyectoDto)
                .retrieve()
                .bodyToMono(ProyectoDto.class)
                .block();
    }

    public void deleteProyecto(Long id) {
        webClientBuilder.build()
                .delete()
                .uri(proyectosUrl + "/proyectos/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public List<UsuarioDto> getUsuariosByProyectoId(Long id) {
        return webClientBuilder.build()
                .get()
                .uri(proyectosUrl + "/proyectos/{id}/usuarios", id)
                .retrieve()
                .bodyToFlux(UsuarioDto.class)
                .collectList()
                .block();
    }

    public List<TareaDto> getTareasByProyectoId(Long id) {
        return webClientBuilder.build()
                .get()
                .uri(proyectosUrl + "/proyectos/{id}/tareas", id)
                .retrieve()
                .bodyToFlux(TareaDto.class)
                .collectList()
                .block();
    }

    // Usuarios_Proyectos
    public UsuarioProyectoDto createUsuarioProyecto(UsuarioProyectoDto usuarioProyectoDto) {
        return webClientBuilder.build()
                .post()
                .uri(proyectosUrl + "/usuarios_proyectos")
                .bodyValue(usuarioProyectoDto)
                .retrieve()
                .bodyToMono(UsuarioProyectoDto.class)
                .block();
    }

    public List<UsuarioProyectoDto> getAllUsuariosProyectos() {
        return webClientBuilder.build()
                .get()
                .uri(proyectosUrl + "/usuarios_proyectos")
                .retrieve()
                .bodyToFlux(UsuarioProyectoDto.class)
                .collectList()
                .block();
    }

    public UsuarioProyectoDto getUsuarioProyectoById(Long id) {
        return webClientBuilder.build()
                .get()
                .uri(proyectosUrl + "/usuarios_proyectos/{id}", id)
                .retrieve()
                .bodyToMono(UsuarioProyectoDto.class)
                .block();
    }

    public UsuarioProyectoDto updateUsuarioProyecto(Long id, UsuarioProyectoDto usuarioProyectoDto) {
        return webClientBuilder.build()
                .put()
                .uri(proyectosUrl + "/usuarios_proyectos/{id}", id)
                .bodyValue(usuarioProyectoDto)
                .retrieve()
                .bodyToMono(UsuarioProyectoDto.class)
                .block();
    }

    public void deleteUsuarioProyecto(Long id) {
        webClientBuilder.build()
                .delete()
                .uri(proyectosUrl + "/usuarios_proyectos/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    // Tareas
    public TareaDto createTask(TareaDto tareaDto) {
        return webClientBuilder.build()
                .post()
                .uri(tareasUrl + "/tasks")
                .bodyValue(tareaDto)
                .retrieve()
                .bodyToMono(TareaDto.class)
                .block();
    }

    public TareaDto updateTask(Long taskId, TareaDto tareaDto) {
        return webClientBuilder.build()
                .put()
                .uri(tareasUrl + "/tasks/{taskId}", taskId)
                .bodyValue(tareaDto)
                .retrieve()
                .bodyToMono(TareaDto.class)
                .block();
    }

    public void deleteTask(Long taskId) {
        webClientBuilder.build()
                .delete()
                .uri(tareasUrl + "/tasks/{taskId}", taskId)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public TareaDto getTaskById(Long taskId) {
        return webClientBuilder.build()
                .get()
                .uri(tareasUrl + "/tasks/{taskId}", taskId)
                .retrieve()
                .bodyToMono(TareaDto.class)
                .block();
    }

    public List<TareaDto> getAllTasks(int skip, int limit) {
        return webClientBuilder.build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(tareasUrl + "/tasks")
                        .queryParam("skip", skip)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToFlux(TareaDto.class)
                .collectList()
                .block();
    }

    // Comentarios
    public CommentDto createComment(CommentDto commentDto) {
        return webClientBuilder.build()
                .post()
                .uri(tareasUrl + "/comments")
                .bodyValue(commentDto)
                .retrieve()
                .bodyToMono(CommentDto.class)
                .block();
    }

    public List<CommentDto> getCommentsByTaskId(Long taskId) {
        return webClientBuilder.build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(tareasUrl + "/comments")
                        .queryParam("tarea_id", taskId)
                        .build())
                .retrieve()
                .bodyToFlux(CommentDto.class)
                .collectList()
                .block();
    }

    public CommentDto getCommentById(Long commentId) {
        return webClientBuilder.build()
                .get()
                .uri(tareasUrl + "/comments/{commentId}", commentId)
                .retrieve()
                .bodyToMono(CommentDto.class)
                .block();
    }

    public CommentDto updateComment(Long commentId, CommentDto commentDto) {
        return webClientBuilder.build()
                .put()
                .uri(tareasUrl + "/comments/{commentId}", commentId)
                .bodyValue(commentDto)
                .retrieve()
                .bodyToMono(CommentDto.class)
                .block();
    }

    public void deleteComment(Long commentId) {
        webClientBuilder.build()
                .delete()
                .uri(tareasUrl + "/comments/{commentId}", commentId)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    //Importante (conexión entre proyectos y tareas):
    public List<TareaDto> obtenerTareasPorProyecto(Long proyectoId) {
        return webClientBuilder.build()
                .get()
                .uri(proyectosUrl + "/proyectos/{id}/tareas", proyectoId)
                .retrieve()
                .bodyToFlux(TareaDto.class)
                .collectList()
                .block();
    }
}