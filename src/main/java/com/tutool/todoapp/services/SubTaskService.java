package com.tutool.todoapp.services;

import com.tutool.todoapp.dto.SubtaskDto;

import java.util.List;

public interface SubTaskService {

    List<SubtaskDto> saveSubTasks(List<SubtaskDto> subtaskDtos);
}
