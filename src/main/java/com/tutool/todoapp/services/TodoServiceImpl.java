package com.tutool.todoapp.services;

import com.tutool.todoapp.dto.TodoDto;
import com.tutool.todoapp.dto.TodoFiltersDto;
import com.tutool.todoapp.hanlders.TodoHandler;
import com.tutool.todoapp.models.Todo;
import com.tutool.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {


    @Autowired
    public TodoRepository todoRepository;

    @Override
    public List<TodoDto> getAllTasks() {
        List<Todo> todos = todoRepository.findAll();
        return TodoHandler.mapTodosToTodoDtos(todos);
    }

    @Override
    public List<TodoDto> getAllTasksByStatus(Long statusId) {
        List<Todo> todos = todoRepository.findAllByStatus_StatusIdEquals(statusId);
        return TodoHandler.mapTodosToTodoDtos(todos);
    }

    @Override
    public List<TodoDto> getAllPreviousTasksByDueDate(TodoFiltersDto todoFiltersDto) {
        Date dueDate = null;
        if(todoFiltersDto.getDueDateTime() == null) {
            dueDate = new Date();
        }
        assert dueDate != null;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dueDate.toInstant(), ZoneId.systemDefault());
        dueDate = Date.from(localDateTime.toLocalDate().atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        List<Todo> todos = todoRepository.findByDueDateTimeBeforeOrderByDueDateTimeDesc(dueDate);
        return TodoHandler.mapTodosToTodoDtos(todos);
    }

    @Override
    public List<TodoDto> getAllUpcomingTasksByDueDate(TodoFiltersDto todoFiltersDto) {
        Date dueDate = null;
        if(todoFiltersDto.getDueDateTime() == null) {
            dueDate = new Date();
        }
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dueDate.toInstant(), ZoneId.systemDefault());
        dueDate = Date.from(localDateTime.toLocalDate().atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        List<Todo> todos = todoRepository.findByDueDateTimeAfterOrderByDueDateTimeAsc(dueDate);
        return TodoHandler.mapTodosToTodoDtos(todos);
    }

    @Override
    public List<TodoDto> getTodayTasks(Date dueDate){
        LocalDateTime localDateTime = LocalDateTime.now();
        List<Todo> todos = todoRepository.findByDueDateTimeByYearAndMonthAndDay(localDateTime.getYear(),localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
        return TodoHandler.mapTodosToTodoDtos(todos);
    }

    @Override
    public List<TodoDto> getAllTasksBetween(TodoFiltersDto todoFiltersDto) {
        Date dueDateFrom = todoFiltersDto.getDueDateFrom();
        Date dueDateTo = todoFiltersDto.getDueDateTo();

        LocalDateTime ldtFrom = LocalDateTime.ofInstant(dueDateFrom.toInstant(), ZoneId.systemDefault());
        dueDateFrom = Date.from(ldtFrom.toLocalDate().atTime(LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());

        LocalDateTime ldtTo = LocalDateTime.ofInstant(dueDateTo.toInstant(), ZoneId.systemDefault());
        dueDateTo = Date.from(ldtTo.toLocalDate().atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());

        List<Todo> todos = todoRepository.findByDueDateTimeBetweenOrderByDueDateTimeAsc(dueDateFrom, dueDateTo);
        return TodoHandler.mapTodosToTodoDtos(todos);
    }


}
