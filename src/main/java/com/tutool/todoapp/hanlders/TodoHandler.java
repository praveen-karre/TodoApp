package com.tutool.todoapp.hanlders;

import com.tutool.todoapp.dto.SubtaskDto;
import com.tutool.todoapp.dto.TodoDto;
import com.tutool.todoapp.models.Subtask;
import com.tutool.todoapp.models.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class TodoHandler {

    public static List<TodoDto> mapTodosToTodoDtos(List<Todo> todos) {
        return todos.stream().map(TodoHandler::mapTodoToTodoDto).collect(Collectors.toList());
    }

    public static TodoDto mapTodoToTodoDto(Todo todo) {
        return TodoDto.builder().
                todoId(todo.getTodoId()).
                title(todo.getTitle()).
                description(todo.getDescription()).
                createdDateTime(todo.getCreatedDateTime()).
                updatedDateTime(todo.getUpdatedDateTime()).
                dueDateTime(todo.getDueDateTime()).
                user(UserHandler.mapUserToUserDto(todo.getUser())).
                status(StatusHandler.mapStatusToStatusDto(todo.getStatus())).
                subtasks(mapSubTasksToSubTaskDtos(todo.getSubtasks())).
                build();
    }


    public static List<SubtaskDto> mapSubTasksToSubTaskDtos(List<Subtask> subTasks) {
        return subTasks.stream().map(TodoHandler::mapSubtasktoSubtaskDto).collect(Collectors.toList());
    }

    public static SubtaskDto mapSubtasktoSubtaskDto(Subtask subtask) {
        return SubtaskDto.builder().subTaskId(subtask.getSubTaskId()).
                title(subtask.getTitle()).
                description(subtask.getDescription()).
                comments(subtask.getComments()).
                status(StatusHandler.mapStatusToStatusDto(subtask.getStatus())).
                todoId(subtask.getTodo().getTodoId()).
                build();
    }
}
