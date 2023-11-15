package com.tutool.todoapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subtask {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long subTaskId;
    private String title;
    private String description;
    private String comments;
    private Date dueDateTime;
    private Long todoId;

    /*@ManyToOne(fetch = FetchType.LAZY)
    private Todo todo;*/


    /*@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "todoId", referencedColumnName = "todoId")
    private Todo todo;*/
    @OneToOne
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    private Status status;
}
