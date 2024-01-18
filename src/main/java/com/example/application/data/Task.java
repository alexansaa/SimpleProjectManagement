package com.example.application.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private String taskName;
    private String description;
    private LocalDate creationDate;
    private List<User> assignedUsers;
    private String taskStatus;
    private List<Comment> comments;

    // Constructor
    public Task(String taskName, String description, LocalDate creationDate,
                List<User> assignedUsers, String taskStatus, List<Comment> comments) {
        this.taskName = taskName;
        this.description = description;
        this.creationDate = creationDate;
        this.assignedUsers = assignedUsers;
        this.taskStatus = taskStatus;
        this.comments = comments;
    }

    // Getters
    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<User> getAssignedUsers() {
        return assignedUsers;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public List<Comment> getComments() {
        return comments;
    }

    // Setters
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setAssignedUsers(List<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Comment getCommentByIndex(int index) {
        return this.comments.get(index);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void updateComment(Comment comment, Comment newComment) {
        int index =  this.comments.indexOf(comment);
        this.comments.set(index, newComment);
    }

    public void deleteComment(Comment comment) {
        int index = this.comments.indexOf(comment);
        this.comments.remove(index);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", assignedUsers=" + assignedUsers +
                ", taskStatus='" + taskStatus + '\'' +
                // ", comments=" + comments +
                '}';
    }
}
