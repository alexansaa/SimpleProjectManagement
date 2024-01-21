package com.example.application.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {
    private String projectName;
    private LocalDate creationDate;
    private LocalDate dueDate;
    private String description;
    private List<User> assignedUsers = new ArrayList<>();
    private User creatorOwner;
    private List<Task> taskList = new ArrayList<>();

    // Constructor
    public Project(String projectName, LocalDate creationDate, LocalDate dueDate, String description,
        List<User> assignedUsers, User creatorOwner, List<Task> taskList) {
        this.projectName = projectName;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.description = description;
        this.creatorOwner = creatorOwner;
        this.taskList = taskList;
        for (User usr : assignedUsers) {
            this.addAssignedUser(usr);
        }
    }

    public Project(){
    }

    // Getters
    public String getProjectName() {
        return projectName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfTasks() {
        return this.taskList.size();
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }

    public User getCreatorOwner() {
        return creatorOwner;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    // Setters
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssignedUsers(List<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public User getAssignedUserByIndex(int index) {
        return this.assignedUsers.get(index);
    }

    public void addAssignedUser(User user) {
        boolean usrExists = false;
        for (User usr : assignedUsers) {
            if (usr.getUsername() == user.getUsername()) {
                usrExists = true;
            }
        }
        if (!usrExists) {
            this.assignedUsers.add(user);
        }

        boolean prjExists = false;
        for (Project prj : user.getProjects()){
            if (prj.getProjectName() == this.projectName) {
                prjExists = true;
            }
        }
        if (!prjExists) {
            user.addProject(this);
        }
    }

    public void updateAssignedUser(User user, User newUser) {
        int index = this.assignedUsers.indexOf(user);
        this.assignedUsers.set(index, newUser);
    }

    public void deleteAssignedUser(User user) {
        int index = this.assignedUsers.indexOf(user);
        this.assignedUsers.remove(index);
    }

    public void setCreatorOwner(User creatorOwner) {
        this.creatorOwner = creatorOwner;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Task getTaskByIndex(int index) {
        return this.taskList.get(index);
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void updateTask(Task task, Task newTask) {
        int index = this.taskList.indexOf(task);
        this.taskList.set(index, newTask);
    }

    public void removeTask(Task task) {
        int index = this.taskList.indexOf(task);
        this.taskList.remove(index);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", description='" + description + '\'' +
                ", numberOfTasks=" + this.taskList.size() +
                ", assignedUsers=" + assignedUsers +
                ", creatorOwner='" + creatorOwner + '\'' +
                // ", taskList=" + taskList +
                '}';
    }

    public static List<Object> getObjectsList(List<Project> projects) {
        List<Object> myObjects = new ArrayList<>();
        
        for (Object obj : projects) {
            if (obj instanceof Object) {
                myObjects.add((Object) obj);
            }
        }

        return myObjects;
    }
}

