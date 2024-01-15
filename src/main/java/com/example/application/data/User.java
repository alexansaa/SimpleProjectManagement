package com.example.application.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaadin.flow.component.template.Id;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

import java.util.List;
import java.util.Set;

@Entity
public class User extends AbstractEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @JsonIgnore
    private String hashedPassword;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Lob
    @Column(length = 1000000)
    private byte[] profilePicture;

    @ManyToMany
    @JoinTable(
        name = "user - project",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> Proyectos_de_Usuario;

    @ManyToMany
    @JoinTable(
        name = "user - task",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> Tareas_de_Usuario;

    @ManyToMany
    @JoinTable(
        name = "user - comment",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private List<Comment> Comentarios_de_Usuario;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public byte[] getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
    public void setUserProjects(List<Project> UserProjects) {
        this.Proyectos_de_Usuario = UserProjects;
    }
    public List<Project> getUserProjects() {
        return this.Proyectos_de_Usuario;
    }
    public void addUserProject(Project newProject) {
        this.Proyectos_de_Usuario.add(newProject);
    }
    public void deleteUserProject(Project project) {
        this.Proyectos_de_Usuario.remove(project);
    }
    public void updateUserProject(Project project, Project NewProject) {
        int index = this.Proyectos_de_Usuario.indexOf(project);
        if (index != -1) {
            this.Proyectos_de_Usuario.set(index, NewProject);
        } else {
            // Handle the case where the project is not found in the list
        }
    }
    public Project getUserProject(int index) {
        return this.Proyectos_de_Usuario.get(index);
    }
    public void setUserTasks(List<Task> UserTasks) {
        this.Tareas_de_Usuario = UserTasks;
    }
    public List<Task> getUserTasks() {
        return this.Tareas_de_Usuario;
    }
    public void addUserTask(Task newTask) {
        this.Tareas_de_Usuario.add(newTask);
    }
    public void deleteUserTask(Task task) {
        this.Tareas_de_Usuario.remove(task);
    }
    public void updateUserTask(Task task, Task NewTask) {
        int index = this.Tareas_de_Usuario.indexOf(task);
        if (index != -1) {
            this.Tareas_de_Usuario.set(index, NewTask);
        } else {
            // Handle the case where the task is not found in the list
        }
    }
    public Task getUserTask(int index) {
        return this.Tareas_de_Usuario.get(index);
    }
    public void setUserComments(List<Comment> UserComments) {
        this.Comentarios_de_Usuario = UserComments;
    }
    public List<Comment> getUserComments() {
        return this.Comentarios_de_Usuario;
    }
    public void addUserComment(Comment newComment) {
        this.Comentarios_de_Usuario.add(newComment);
    }
    public void deleteUserComment(Comment comment) {
        this.Comentarios_de_Usuario.remove(comment);
    }
    public void updateUserComment(Comment comment, Comment NewComment) {
        int index = this.Comentarios_de_Usuario.indexOf(comment);
        if (index != -1) {
            this.Comentarios_de_Usuario.set(index, NewComment);
        } else {
            // Handle the case where the task is not found in the list
        }
    }
    public Comment getUserComment(int index) {
        return this.Comentarios_de_Usuario.get(index);
    }

}
