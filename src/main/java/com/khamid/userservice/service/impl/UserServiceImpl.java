package com.khamid.userservice.service.impl;

import com.khamid.userservice.model.UserDto;
import com.khamid.userservice.model.UserEntity;
import com.khamid.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto dto) {
        UserEntity user = new UserEntity();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setCompanyId(dto.getCompanyId());

        userRepository.save(user);
        dto.setId(user.getId());

        return dto;
    }

    @Override
    public UserDto updateUser(UserDto user, Long id) {


        return null;
    }

    @Override
    public UserDto getUserById(Integer id) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }

}
