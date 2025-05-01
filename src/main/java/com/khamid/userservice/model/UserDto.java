package com.khamid.userservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private Long companyId;
}
