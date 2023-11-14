package com.tutool.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoFiltersDto {
    public Date dueDateTime;
    public Date dueDateFrom;
    public Date dueDateTo;
}
