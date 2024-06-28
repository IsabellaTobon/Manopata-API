package com.manopata.api.users.controller;

import com.manopata.api.users.dto.UserRequest;
import com.manopata.api.users.dto.UserResponse;
import com.manopata.api.users.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    // CREATE NEW USER
    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request)
    {
        return ResponseEntity.ok(this.userService.create(request));
    }

    //SEARCH USER BY ID
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        UserResponse userResponse = this.userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }



    //UPDATE USER INFORMATION
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request) {
        UserResponse userResponse = this.userService.update(request);
        return ResponseEntity.ok(userResponse);
    }

    //DELETE USER BY ID
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
