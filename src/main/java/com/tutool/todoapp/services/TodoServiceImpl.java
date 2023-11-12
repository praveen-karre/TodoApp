package com.tutool.todoapp.services;

import com.tutool.todoapp.dto.TodoDto;
import com.tutool.todoapp.hanlders.TodoHandler;
import com.tutool.todoapp.hanlders.UserHandler;
import com.tutool.todoapp.models.Todo;
import com.tutool.todoapp.models.User;
import com.tutool.todoapp.repository.TodoRepository;
import com.tutool.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {


    @Autowired
    public TodoRepository todoRepository;

    @Override
    public List<TodoDto> getTodos() {
        List<Todo> todos = todoRepository.findAll();
        return TodoHandler.mapTodosToTodoDtos(todos);
    }

    @Override
    public List<TodoDto> getPreviousTasks(Date dueDate) {
        if(dueDate == null) {
            dueDate = new Date();
        }
        List<Todo> todos = todoRepository.findByDueDateBefore(dueDate);
        return TodoHandler.mapTodosToTodoDtos(todos);
    }

    @Override
    public List<TodoDto> getUpcomingTasks(Date dueDate) {
        if(dueDate == null) {
            dueDate = new Date();
        }
        List<Todo> todos = todoRepository.findByDueDateAfter(dueDate);
        return TodoHandler.mapTodosToTodoDtos(todos);
    }

    @Override
    public List<TodoDto> getTodayTasks(Date dueDate) throws ParseException {
        if(dueDate == null) {
            dueDate = new Date();
        }
        List<Todo> todos = todoRepository.findByDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01"));
        return TodoHandler.mapTodosToTodoDtos(todos);
    }


}
