package com.khamid.userservice.controller;

import com.khamid.userservice.common.ListDto;
import com.khamid.userservice.model.UserDto;
import com.khamid.userservice.model.UserWithCompanyDto;
import com.khamid.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUserData(@PathVariable Long id, @RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.updateUser(dto, id));
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id, @RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.getUserById(dto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allUsers")
    public ResponseEntity<ListDto<UserDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUser(pageable));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<UserWithCompanyDto> getUserWithCompany(@PathVariable Long id) {
        UserWithCompanyDto userWithCompanyDto = userService.getUserWithCompany(id);
        return ResponseEntity.ok(userWithCompanyDto);
    }
}
