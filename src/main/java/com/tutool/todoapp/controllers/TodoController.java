package com.tutool.todoapp.controllers;


import com.tutool.todoapp.dto.SubtaskDto;
import com.tutool.todoapp.dto.TodoDto;
import com.tutool.todoapp.dto.TodoFiltersDto;
import com.tutool.todoapp.repository.SubtaskRepository;
import com.tutool.todoapp.services.SubTaskService;
import com.tutool.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    public TodoService todoService;

    @Autowired
    public SubTaskService subTaskService;

    @GetMapping("/{id}")
    public TodoDto getAllDetails(@PathVariable("id") Long id) {
        return todoService.getAllTasksById(id);
    }


    @GetMapping("/getAllTasks")
    public List<TodoDto> getAllTasks(@RequestHeader("user-id") String userId) {
        return todoService.getAllTasks(userId);
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

    @PostMapping("/addOrEditTask")
    public TodoDto addOrEditTask(@RequestBody TodoFiltersDto todoFiltersDto) {
        return todoService.addOrEditTask(todoFiltersDto);
    }

    @PostMapping("/addOrEditSubtask")
    public List<SubtaskDto> addOrEditSubTask(@RequestBody TodoFiltersDto todoFiltersDto) {
        return subTaskService.saveSubTasks(todoFiltersDto.getSubTasks());
    }

    @DeleteMapping("/deleteTodo/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        todoService.deleteTodo(id);
    }
}
