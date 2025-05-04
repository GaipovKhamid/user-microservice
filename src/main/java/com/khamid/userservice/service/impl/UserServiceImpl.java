package com.khamid.userservice.service.impl;

import com.khamid.userservice.common.ListDto;
import com.khamid.userservice.common.exps.NotFound;
import com.khamid.userservice.model.CompanyDto;
import com.khamid.userservice.model.UserDto;
import com.khamid.userservice.model.UserEntity;
import com.khamid.userservice.model.UserWithCompanyDto;
import com.khamid.userservice.repository.UserRepository;
import com.khamid.userservice.service.CompanyClient;
import com.khamid.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompanyClient companyClient;

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
    public UserDto updateUser(UserDto dto, Long id) {
        var optional = userRepository.findById(id);

        if (optional.isEmpty()) {
            throw new NotFound("User not found");
        }

        UserEntity user = optional.get();

        if (dto.getFirstName() != null) {
            user.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null) {
            user.setLastName(dto.getLastName());
        }

        if (dto.getPhoneNumber() != null) {
            user.setPhoneNumber(dto.getPhoneNumber());
        }

        if (dto.getCompanyId() != null) {
            user.setCompanyId(dto.getCompanyId());
        }

        userRepository.save(user);
        dto.setId(user.getId());

        return dto;
    }

    @Override
    public UserDto getUserById(UserDto dto, Long id) {
        var optional = userRepository.findById(id);

        if (optional.isEmpty()) {
            throw new NotFound("User not exist");
        }

        return dto;
    }

    @Override
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFound("User not exist");
        }
        userRepository.deleteById(id);
    }

    @Override
    public ListDto<UserDto> getAllUser(Pageable pageable) {
        List<UserDto> userDtoList = userRepository.findAll(pageable).stream()
                .map(userEntity ->
                        UserDto.builder()
                                .id(userEntity.getId())
                                .firstName(userEntity.getFirstName())
                                .lastName(userEntity.getLastName())
                                .phoneNumber(userEntity.getPhoneNumber())
                                .companyId(userEntity.getCompanyId())
                                .build())
                .toList();
        return new ListDto<>(userDtoList);
    }

    @Override
    public UserWithCompanyDto getUserWithCompany(Long userId){
        UserEntity user = userRepository.findById(userId).orElseThrow();
        CompanyDto companyDto = companyClient.getCompanyById(user.getCompanyId());

        return new UserWithCompanyDto(user.getId(), user.getFirstName(), user.getLastName(), companyDto);
    }
}
