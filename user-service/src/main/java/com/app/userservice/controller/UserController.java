package com.app.userservice.controller;

import com.app.userservice.dto.UserRequest;
import com.app.userservice.dto.UserResponse;
import com.app.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        Optional<UserResponse> userResponseOptional = userService.getUserByUsername(username);
        if (userResponseOptional.isPresent()) {
            return ResponseEntity.ok(userResponseOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

