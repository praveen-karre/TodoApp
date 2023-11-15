package com.tutool.todoapp.hanlders;

import com.tutool.todoapp.dto.StatusDto;
import com.tutool.todoapp.models.Status;

public class StatusHandler {
    public static StatusDto mapStatusToStatusDto(Status status) {
        return StatusDto.builder().
                statusId(status.getStatusId()).
                description(status.getDescription()).
                build();
    }

    public static Status mapStatusDtoToStatus(StatusDto statusDto) {
        return Status.builder().
                statusId(statusDto.getStatusId()).
                description(statusDto.getDescription()).
                build();
    }
}
