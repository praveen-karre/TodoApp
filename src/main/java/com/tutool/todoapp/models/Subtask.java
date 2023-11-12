package com.tutool.todoapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Subtask {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long subTaskId;
    private String title;
    private String description;
    private String comments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "todoId", referencedColumnName = "todoId")
    private Todo todo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    private Status status;
}
