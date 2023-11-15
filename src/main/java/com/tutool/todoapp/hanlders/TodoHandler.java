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

    public static List<Todo> mapTodosDtosToTodo(List<TodoDto> todoDtos) {
        return todoDtos.stream().map(TodoHandler::mapTodoDtoToTodo).collect(Collectors.toList());
    }


    public static Todo mapTodoDtoToTodo(TodoDto todoDto) {
        Todo todo = Todo.builder().
                todoId(todoDto.getTodoId()).
                title(todoDto.getTitle()).
                description(todoDto.getDescription()).
                createdDateTime(todoDto.getCreatedDateTime()).
                updatedDateTime(todoDto.getUpdatedDateTime()).
                dueDateTime(todoDto.getDueDateTime()).
                user(UserHandler.mapUserDtoToUser(todoDto.getUser())).
                status(StatusHandler.mapStatusDtoToStatus(todoDto.getStatus())).
                subtasks(mapSubTasksDtosToSubTasks(todoDto.getSubtasks())).
                build();
        return todo;
    }


    public static List<SubtaskDto> mapSubTasksToSubTaskDtos(List<Subtask> subTasks) {
        if(subTasks == null) {
            return null;
        }
        return subTasks.stream().
                map(TodoHandler::mapSubtasktoSubtaskDto).collect(Collectors.toList());
    }

    public static SubtaskDto mapSubtasktoSubtaskDto(Subtask subtask) {
        if(subtask == null) {
            return null;
        }
        return SubtaskDto.builder().subTaskId(subtask.getSubTaskId()).
                title(subtask.getTitle()).
                description(subtask.getDescription()).
                comments(subtask.getComments()).
                status(StatusHandler.mapStatusToStatusDto(subtask.getStatus())).
                build();
    }

    public static List<Subtask> mapSubTasksDtosToSubTasks(List<SubtaskDto> subTasksDtos) {
        if(subTasksDtos == null) {
            return null;
        }
        return subTasksDtos.stream()
                .map(TodoHandler::mapSubtaskDtotoSubtask).collect(Collectors.toList());
    }

    public static Subtask mapSubtaskDtotoSubtask(SubtaskDto subtaskDto) {
        if(subtaskDto == null) {
            return null;
        }
         return Subtask.builder().subTaskId(subtaskDto.getSubTaskId()).
                    title(subtaskDto.getTitle()).
                    description(subtaskDto.getDescription()).
                    comments(subtaskDto.getComments()).
                    status(StatusHandler.mapStatusDtoToStatus(subtaskDto.getStatus())).
                    //todo(Todo.builder().todoId(subtaskDto.getTodoId()).build()).
                    build();
    }
}
