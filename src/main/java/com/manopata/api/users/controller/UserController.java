package com.manopata.api.users.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/test")
    public ResponseEntity test() {
        //localhost:8080/swagger-ui/index.html
        return new ResponseEntity<>("Hola soy Isabella", HttpStatus.OK);
    }
}
