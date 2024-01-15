package com.example.application.data;

import java.time.LocalDate;

import com.vaadin.flow.component.template.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Comment extends AbstractEntity{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private LocalDate Fecha_Creacion;
    private String Texto;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
}
