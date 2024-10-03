package com.example.microservicio_orquestador.controller;

import com.example.microservicio_orquestador.dto.*;
import com.example.microservicio_orquestador.service.OrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

    @Autowired
    private OrchestratorService orchestratorService;

    // Usuarios
    @PostMapping("/users")
    public RegisterDto createUser(@RequestBody RegisterDto registerDto) {
        return orchestratorService.createUser(registerDto);
    }

    @PostMapping("/users/login")
    public RegisterDto loginUser(@RequestBody LoginDto loginDto) {
        return orchestratorService.loginUser(loginDto);
    }

    @GetMapping("/users")
    public List<RegisterDto> getAllUsers(@RequestHeader("Authorization") String token) {
        return orchestratorService.getAllUsers(token);
    }

    @GetMapping("/users/{id}")
    public RegisterDto getUserById(@PathVariable String id) {
        return orchestratorService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public RegisterDto updateUser(@PathVariable String id, @RequestBody RegisterDto registerDto) {
        return orchestratorService.updateUser(id, registerDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        orchestratorService.deleteUser(id);
    }

    // Roles
    @PostMapping("/roles")
    public RolDto createRole(@RequestBody RolDto rolDto) {
        return orchestratorService.createRole(rolDto);
    }

    @GetMapping("/roles")
    public List<RolDto> getAllRoles(@RequestHeader("Authorization") String token) {
        return orchestratorService.getAllRoles(token);
    }

    @GetMapping("/roles/{id}")
    public RolDto getRoleById(@PathVariable String id) {
        return orchestratorService.getRoleById(id);
    }

    @PutMapping("/roles/{id}")
    public RolDto updateRole(@PathVariable String id, @RequestBody RolDto rolDto) {
        return orchestratorService.updateRole(id, rolDto);
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable String id) {
        orchestratorService.deleteRole(id);
    }

//microservicio_proyectos:
    //proyectos:
    @PostMapping("/proyectos")
    public ProyectoDto createProyecto(@RequestBody ProyectoDto proyectoDto, @RequestParam Long usuarioId) {
        return orchestratorService.createProyecto(proyectoDto, usuarioId);
    }

    @GetMapping("/proyectos")
    public List<ProyectoDto> getProyectosByUsuarioId(@RequestParam Long usuarioId) {
        return orchestratorService.getProyectosByUsuarioId(usuarioId);
    }

    @GetMapping("/proyectos/{id}")
    public ProyectoDto getProyectoById(@PathVariable Long id) {
        return orchestratorService.getProyectoById(id);
    }

    @PutMapping("/proyectos/{id}")
    public ProyectoDto updateProyecto(@PathVariable Long id, @RequestBody ProyectoDto proyectoDto) {
        return orchestratorService.updateProyecto(id, proyectoDto);
    }

    @DeleteMapping("/proyectos/{id}")
    public void deleteProyecto(@PathVariable Long id) {
        orchestratorService.deleteProyecto(id);
    }

    @GetMapping("/proyectos/{id}/usuarios")
    public List<UsuarioDto> getUsuariosByProyectoId(@PathVariable Long id) {
        return orchestratorService.getUsuariosByProyectoId(id);
    }

    @GetMapping("/proyectos/{id}/tareas")
    public List<TareaDto> getTareasByProyectoId(@PathVariable Long id) {
        return orchestratorService.getTareasByProyectoId(id);
    }

    // Usuarios_Proyectos
    @PostMapping("/usuarios_proyectos")
    public UsuarioProyectoDto createUsuarioProyecto(@RequestBody UsuarioProyectoDto usuarioProyectoDto) {
        return orchestratorService.createUsuarioProyecto(usuarioProyectoDto);
    }

    @GetMapping("/usuarios_proyectos")
    public List<UsuarioProyectoDto> getAllUsuariosProyectos() {
        return orchestratorService.getAllUsuariosProyectos();
    }

    @GetMapping("/usuarios_proyectos/{id}")
    public UsuarioProyectoDto getUsuarioProyectoById(@PathVariable Long id) {
        return orchestratorService.getUsuarioProyectoById(id);
    }

    @PutMapping("/usuarios_proyectos/{id}")
    public UsuarioProyectoDto updateUsuarioProyecto(@PathVariable Long id, @RequestBody UsuarioProyectoDto usuarioProyectoDto) {
        return orchestratorService.updateUsuarioProyecto(id, usuarioProyectoDto);
    }

    @DeleteMapping("/usuarios_proyectos/{id}")
    public void deleteUsuarioProyecto(@PathVariable Long id) {
        orchestratorService.deleteUsuarioProyecto(id);
    }

//microservicio_tareas:
    // Tareas
    @PostMapping("/tasks")
    public TareaDto createTask(@RequestBody TareaDto tareaDto) {
        return orchestratorService.createTask(tareaDto);
    }

    @PutMapping("/tasks/{taskId}")
    public TareaDto updateTask(@PathVariable Long taskId, @RequestBody TareaDto tareaDto) {
        return orchestratorService.updateTask(taskId, tareaDto);
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        orchestratorService.deleteTask(taskId);
    }

    @GetMapping("/tasks/{taskId}")
    public TareaDto getTaskById(@PathVariable Long taskId) {
        return orchestratorService.getTaskById(taskId);
    }

    @GetMapping("/tasks")
    public List<TareaDto> getAllTasks(@RequestParam int skip, @RequestParam int limit) {
        return orchestratorService.getAllTasks(skip, limit);
    }

    // Comentarios
    @PostMapping("/comments")
    public CommentDto createComment(@RequestBody CommentDto commentDto) {
        return orchestratorService.createComment(commentDto);
    }

    @GetMapping("/comments")
    public List<CommentDto> getCommentsByTaskId(@RequestParam Long tarea_id) {
        return orchestratorService.getCommentsByTaskId(tarea_id);
    }

    @GetMapping("/comments/{commentId}")
    public CommentDto getCommentById(@PathVariable Long commentId) {
        return orchestratorService.getCommentById(commentId);
    }

    @PutMapping("/comments/{commentId}")
    public CommentDto updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto) {
        return orchestratorService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        orchestratorService.deleteComment(commentId);
    }
}