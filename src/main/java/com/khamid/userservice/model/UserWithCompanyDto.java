package com.khamid.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserWithCompanyDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private CompanyDto company;
}
