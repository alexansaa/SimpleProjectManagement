package com.example.application.data;

import java.io.Serializable;
import java.time.LocalDate;

public class Comment implements Serializable {
    private User owner;
    private String text;
    private LocalDate commentDate;

    // Constructor
    public Comment(User owner, String text, LocalDate commentDate) {
        this.owner = owner;
        this.text = text;
        this.commentDate = commentDate;
    }

    // Getters
    public User getOwner() {
        return owner;
    }

    public String getText() {
        return text;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    // Setters
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Comment{" +
                "owner=" + owner +
                ", text='" + text + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}
