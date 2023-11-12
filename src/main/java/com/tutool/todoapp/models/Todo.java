package com.tutool.todoapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long todoId;
    private String title;
    private String description;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Date dueDate;
    private boolean archive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    private Status status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "todoId", referencedColumnName = "todoId")
    private List<Subtask> subtasks;
}
