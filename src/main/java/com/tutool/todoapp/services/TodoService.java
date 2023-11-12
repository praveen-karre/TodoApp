package com.tutool.todoapp.services;

import com.tutool.todoapp.dto.TodoDto;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TodoService {
    List<TodoDto> getTodos();
    List<TodoDto> getPreviousTasks(Date dueDate);
    List<TodoDto> getUpcomingTasks(Date dueDate);
    List<TodoDto> getTodayTasks(Date dueDate) throws ParseException;
}
