package com.example.application.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.config.Task;

import com.vaadin.flow.component.template.Id;

@Entity
public class Project extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nombre_Proyecto;
    private LocalDate Fecha_Creacion;
    private LocalDate Fecha_Entrega;
    private String Descripcion;
    private Integer Numero_Tareas;

    @ManyToMany(mappedBy = "Proyectos_de_Usuario")
    private List<User> Usuarios_Asignados = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Task> Tareas;

    public String getNombreProyecto() {
        return Nombre_Proyecto;
    }
    public void setNombreProyecto(String Nombre_Proyecto) {
        this.Nombre_Proyecto = Nombre_Proyecto;
    }
    public LocalDate getFechaCreacion() {
        return Fecha_Creacion;
    }
    public void setFechaCreacion(LocalDate Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }
    public LocalDate getFechaEntrega() {
        return Fecha_Entrega;
    }
    public void setFechaEntrega(LocalDate Fecha_Entrega) {
        this.Fecha_Entrega = Fecha_Entrega;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public Integer getNumeroTareas() {
        return Numero_Tareas;
    }
    public void setNumeroTareas(Integer Numero_Tareas) {
        this.Numero_Tareas = Numero_Tareas;
    }
    public List<Task> getTasks() {
        return Tareas;
    }
    public void setTasks(List<Task> Tareas) {
        this.Tareas = Tareas;
    }
    public void addTask(Task Tarea) {
        this.Tareas.add(Tarea);
    }
    public void deleteTask(Task Tarea) {
        this.Tareas.remove(Tarea);
    }
    public void updateTask(Task Tarea, Task NewTarea) {
        int index = this.Tareas.indexOf(Tarea);
        if (index != -1) {
            this.Tareas.set(index, NewTarea);
        } else {
            // Handle the case where the task is not found in the list
        }
    }
    public List<User> getUsers() {
        return Usuarios_Asignados;
    }

    public void setUsers(List<User> users) {
        this.Usuarios_Asignados = users;
    }

    public void addUser(User user) {
        this.Usuarios_Asignados.add(user);
        user.addUserProject(this);
    }

    public void removeUser(User user) {
        this.Usuarios_Asignados.remove(user);
        user.deleteUserProject(this);
    }
}
