package com.tutool.todoapp.services;

import com.tutool.todoapp.dto.UserDto;
import com.tutool.todoapp.hanlders.UserHandler;
import com.tutool.todoapp.models.User;
import com.tutool.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return UserHandler.mapUsersToUserDtos(users);
    }
}
