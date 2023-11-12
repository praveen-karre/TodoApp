package com.tutool.todoapp.hanlders;

import com.tutool.todoapp.dto.UserDto;
import com.tutool.todoapp.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserHandler {

    public static List<UserDto> mapUsersToUserDtos(List<User> users) {
        return users.stream().map(UserHandler::mapUserToUserDto).collect(Collectors.toList());
    }

    public static UserDto mapUserToUserDto(User user) {
        return UserDto.builder().userId(user.getUserId()).password(user.getPassword()).role(user.getRole()).build();
    }
}
