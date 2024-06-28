package com.manopata.api.auth.controller;

import com.manopata.api.auth.dto.LoginRequest;
import com.manopata.api.auth.dto.TokenResponse;
import com.manopata.api.auth.exceptions.InvalidCredentialsException;
import com.manopata.api.users.dto.UserWithPasswordResponse;
import com.manopata.api.users.services.UserService;
import com.manopata.api.utlis.auth.JwtTokenUtil;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @SneakyThrows
    @PostMapping("/login")
    public ResponseEntity login(@NotNull @RequestBody LoginRequest request)
    {
        UserWithPasswordResponse user = this.userService.getUserByUsername(request.getUsername());
        if (user.getPassword().equals(request.getPassword()))
        {
            String token = String.valueOf(jwtTokenUtil.generateToken(user.getNickname(), user.getRole()));
            return ResponseEntity.ok(new TokenResponse(token));
//            return new ResponseEntity<>(this.jwtTokenUtil.generateToken(user.getNickname(), user.getRole()),
//                HttpStatus.OK);
        }
        throw new InvalidCredentialsException();
    }

    @SneakyThrows
    @PostMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateToken(@NotNull @PathVariable String token)
    {
        boolean isValid = this.jwtTokenUtil.isTokenStillValid(token);
        return ResponseEntity.ok(isValid);
//        return new ResponseEntity<>(this.jwtTokenUtil.isTokenStillValid(token),
//                HttpStatus.OK);
    }
}
