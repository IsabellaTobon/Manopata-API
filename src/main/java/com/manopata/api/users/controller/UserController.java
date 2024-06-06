package com.manopata.api.users.controller;

import com.manopata.api.users.dto.UserRequest;
import com.manopata.api.users.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/test")
    public ResponseEntity test() {
        //localhost:8080/swagger-ui/index.html
        return new ResponseEntity<>("Hola soy Isabella", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserRequest request) {
        return new ResponseEntity<>(this.userService.create(request), HttpStatus.OK);

    }
}
