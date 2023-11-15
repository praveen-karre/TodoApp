package com.tutool.todoapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long todoId;
    private String title;
    private String description;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Date dueDateTime;
    private boolean archive;


    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    @OneToOne
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "todoId", referencedColumnName = "todoId")
    private List<Subtask> subtasks;
}
