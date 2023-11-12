package com.tutool.todoapp.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusDto {
    private Long statusId;
    private String description;

}
