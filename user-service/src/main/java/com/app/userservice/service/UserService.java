package com.app.userservice.service;

import com.app.userservice.dto.UserRequest;
import com.app.userservice.dto.UserResponse;
import com.app.userservice.feign.UserInterface;
import com.app.userservice.model.User;
import com.app.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    
    @Autowired
    UserInterface userInterface;
    public void createUser(UserRequest userRequest) {
        User user = User.builder()
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .dateOfBirth(userRequest.getDateOfBirth())
                .phoneNumber(userRequest.getPhoneNumber())
                .password(userRequest.getPassword())
                .build();
        userRepository.save(user);
        log.info("user is saved");
    }

    public List<UserResponse> getAllUser() {
            List<User> users = userRepository.findAll();
            return users.stream().map(this::mapToUserResponse).toList();
        }

        private UserResponse mapToUserResponse (User user){
            return UserResponse.builder()
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .dateOfBirth(user.getDateOfBirth())
                    .phoneNumber(user.getPhoneNumber())
                    .password(user.getPassword())
                    .build();
        }

}
