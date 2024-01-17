package com.example.application.data;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String role;
    private List<Project> projects;

    // Constructor
    public User(String username, String password, String role, List<Project> projects) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.projects = projects;
    }
    public User() {
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project getProjectByindex(int index) {
        return projects.get(index);
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void deleteProject(Project project) {
        this.projects.remove((project));
    }

    public void updateProject(Project project, Project newProject) {
        int index = this.projects.indexOf(project);
        this.projects.set(index, newProject);
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                // ", projects=" + Arrays.toString(projects) +
                '}';
    }
}
