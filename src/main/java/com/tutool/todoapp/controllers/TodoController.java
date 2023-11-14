package com.tutool.todoapp.controllers;


import com.tutool.todoapp.dto.TodoDto;
import com.tutool.todoapp.dto.TodoFiltersDto;
import com.tutool.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    public TodoService todoService;

    @GetMapping("/getAllTasks")
    public List<TodoDto> getAllTasks() {
        return todoService.getAllTasks();
    }

    @PostMapping("/getAllPreviousTasks")
    public List<TodoDto> getAllPreviousTasksByDueDate(@RequestBody TodoFiltersDto todoFiltersDto) {
        return todoService.getAllPreviousTasksByDueDate(todoFiltersDto);
    }

    @PostMapping("/getAllUpcomingTasks")
    public List<TodoDto> getAllUpcomingTasksByDueDate(@RequestBody TodoFiltersDto todoFiltersDto) {
        return todoService.getAllUpcomingTasksByDueDate(todoFiltersDto);
    }

    @PostMapping("/getTodayTasks")
    public List<TodoDto> getTodayTasks(@RequestBody TodoFiltersDto todoFiltersDto) {
        return todoService.getTodayTasks(todoFiltersDto.getDueDateTime());
    }

    @PostMapping("/getAllTasks/date-range")
    public List<TodoDto> getAllTasksBetween(@RequestBody TodoFiltersDto todoFiltersDto) {
        return todoService.getAllTasksBetween(todoFiltersDto);
    }
}
