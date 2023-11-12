package com.tutool.todoapp.controllers;

import com.tutool.todoapp.dto.UserDto;
import com.tutool.todoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/getusers")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

}
