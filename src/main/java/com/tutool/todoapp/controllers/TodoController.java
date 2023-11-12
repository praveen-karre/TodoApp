package com.tutool.todoapp.controllers;


import com.tutool.todoapp.dto.TodoDto;
import com.tutool.todoapp.dto.TodoFiltersDto;
import com.tutool.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    public TodoService todoService;

    @GetMapping("/getAllTasks")
    public List<TodoDto> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/getPreviousTasks")
    public List<TodoDto> getPreviousTasks(@RequestBody TodoFiltersDto todoFiltersDto) {
        return todoService.getPreviousTasks(todoFiltersDto.getDueDateTime());
    }

    @PostMapping("/getUpcomingTasks")
    public List<TodoDto> getUpcomingTasks(@RequestBody TodoFiltersDto todoFiltersDto) {
        return todoService.getUpcomingTasks(todoFiltersDto.getDueDateTime());
    }

    @PostMapping("/getTodayTasks")
    public List<TodoDto> getTodayTasks(@RequestBody TodoFiltersDto todoFiltersDto) throws ParseException {
        return todoService.getTodayTasks(todoFiltersDto.getDueDateTime());
    }
}
