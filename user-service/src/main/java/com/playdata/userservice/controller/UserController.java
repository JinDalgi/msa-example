package com.playdata.userservice.controller;

import com.playdata.userservice.dto.RequestCreateUserDto;
import com.playdata.userservice.dto.ResponseFindUserDto;
import com.playdata.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "server is available!";
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody RequestCreateUserDto userDto) {
        userService.createUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/users/{uuid}")
    public ResponseEntity<?> findUserByUuid(@PathVariable String uuid) {
        ResponseFindUserDto userDto = userService.findUserByUuid(uuid);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/users/all")
    public ResponseEntity<?> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }

}
