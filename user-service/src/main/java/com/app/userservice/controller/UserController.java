package com.app.userservice.controller;

import com.app.userservice.dto.UserRequest;
import com.app.userservice.dto.UserResponse;
import com.app.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCommentaire(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllCommentaire(){
        return userService.getAllUser();
    }
}

