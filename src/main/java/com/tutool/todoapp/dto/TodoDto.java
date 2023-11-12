package com.tutool.todoapp.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
    private Long todoId;
    private String title;
    private String description;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Date dueDate;
    private boolean archive;
    private UserDto user;
    private StatusDto status;
    private List<SubtaskDto> subtasks;
}
