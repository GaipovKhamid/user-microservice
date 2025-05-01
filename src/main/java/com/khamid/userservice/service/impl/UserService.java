package com.khamid.userservice.service.impl;

import com.khamid.userservice.model.UserDto;

public interface UserService {
    UserDto addUser(UserDto user);

    UserDto updateUser(UserDto user, Long id);

    UserDto getUserById(Integer id);

    void deleteUserById(Integer id);
}
