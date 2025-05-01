package com.khamid.userservice.service;

import com.khamid.userservice.common.ListDto;
import com.khamid.userservice.model.UserDto;
import org.springframework.data.domain.Pageable;


public interface UserService {
    UserDto addUser(UserDto user);

    UserDto updateUser(UserDto user, Long id);

    UserDto getUserById(UserDto dto, Long id);

    void deleteUserById(Long id);

    ListDto<UserDto> getAllUser(Pageable pageable);
}
