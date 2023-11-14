package com.tutool.todoapp.services;

import com.tutool.todoapp.dto.TodoDto;
import com.tutool.todoapp.dto.TodoFiltersDto;

import java.util.Date;
import java.util.List;

public interface TodoService {
    List<TodoDto> getAllTasks();

    List<TodoDto> getAllTasksByStatus(Long statusId);
    List<TodoDto> getAllPreviousTasksByDueDate(TodoFiltersDto todoFiltersDto);
    List<TodoDto> getAllUpcomingTasksByDueDate(TodoFiltersDto todoFiltersDto);
    List<TodoDto> getTodayTasks(Date dueDate);

    List<TodoDto> getAllTasksBetween(TodoFiltersDto todoFiltersDto);
}
