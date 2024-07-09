package com.manopata.api.users.controller;

import com.manopata.api.auth.exceptions.InvalidTokenException;
import com.manopata.api.users.dto.UserRequest;
import com.manopata.api.users.dto.UserResponse;
import com.manopata.api.users.services.UserService;
import com.manopata.api.utlis.shared.EndpointUtils;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @SneakyThrows
    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id,
                                                    @NotNull @RequestHeader(value = "Oauth") String token) {
        String url = EndpointUtils.getEndpointUrl();
        url = url.replace("/" + id, "");
        if (this.userService.isTokenValid(token, url))
        {
            UserResponse userResponse = this.userService.getUserById(id);
            return ResponseEntity.ok(userResponse);
        }
        throw new InvalidTokenException();
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
