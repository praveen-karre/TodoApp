package com.tutool.todoapp.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubtaskDto {
    private Long subTaskId;
    private String title;
    private String description;
    private String comments;
    private Long todoId;
    private StatusDto status;
}
