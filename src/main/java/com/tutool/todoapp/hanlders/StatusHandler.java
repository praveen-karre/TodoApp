package com.tutool.todoapp.hanlders;

import com.tutool.todoapp.dto.StatusDto;
import com.tutool.todoapp.dto.TodoDto;
import com.tutool.todoapp.models.Status;
import com.tutool.todoapp.models.Todo;

public class StatusHandler {
    public static StatusDto mapStatusToStatusDto(Status status) {
        return StatusDto.builder().
                statusId(status.getStatusId()).
                description(status.getDescription()).
                build();
    }
}
