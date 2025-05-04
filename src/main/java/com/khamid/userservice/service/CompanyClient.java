package com.khamid.userservice.service;

import com.khamid.userservice.model.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "company-service", url = "https://localhost:8082")
public interface CompanyClient {
    @GetMapping("/companies/{id}")
    CompanyDto getCompanyById(@PathVariable("id") Long id);
}
