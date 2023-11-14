package com.tutool.todoapp.services;

import com.tutool.todoapp.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
