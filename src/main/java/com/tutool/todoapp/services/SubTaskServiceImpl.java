package com.tutool.todoapp.services;

import com.tutool.todoapp.dto.SubtaskDto;
import com.tutool.todoapp.hanlders.TodoHandler;
import com.tutool.todoapp.models.Subtask;
import com.tutool.todoapp.repository.SubtaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskServiceImpl implements SubTaskService {

    @Autowired
    SubtaskRepository subtaskRepository;
    @Override
    public List<SubtaskDto> saveSubTasks(List<SubtaskDto> subtaskDtos) {
        List<Subtask> subtasks = TodoHandler.mapSubTasksDtosToSubTasks(subtaskDtos);
        subtasks = subtaskRepository.saveAll(subtasks);
        return TodoHandler.mapSubTasksToSubTaskDtos(subtasks);
    }
}
