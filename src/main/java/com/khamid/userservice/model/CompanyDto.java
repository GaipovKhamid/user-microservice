package com.khamid.userservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class CompanyDto {
    private Long id;
    private String name;
    private Double budget;
}
