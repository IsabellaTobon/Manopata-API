package com.manopata.api.users.services;

import com.manopata.api.roles.exceptions.RoleNotExistsException;
import com.manopata.api.roles.interfaces.models.Role;
import com.manopata.api.roles.interfaces.repositories.RoleRepository;
import com.manopata.api.users.dto.*;
import com.manopata.api.users.exceptions.*;
import com.manopata.api.users.interfaces.repositories.UserRepository;
import com.manopata.api.users.interfaces.models.User;

import com.manopata.api.utlis.auth.JwtTokenUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @SneakyThrows
    public UserResponse create(UserRequest request) {
        if (this.userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserEmailExistsException();
        }

        if (this.userRepository.findByNickname(request.getNickname()).isPresent()) {
            throw new UserNicknameExistsException();
        }
        Role role = findRoleByName(request.getRole());
//        Role role = findRoleByName("USER");
        String id = UUID.randomUUID().toString();
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User model = this.userRepository.save(request.toModel(id, encodedPassword, String.valueOf(role)));
        return new UserResponse(model);
    }

    @SneakyThrows
    public UserResponse update(UpdateUserRequest request) {
        Optional<User> optionalUser = this.userRepository.findByEmail(request.getEmail());
        if (optionalUser.isEmpty()) {
            throw new UserEmailNotExistsException();
        }

        User model = optionalUser.get();
        if (!passwordEncoder.matches(request.getCurrentPassword(), model.getPassword())) {
            throw new InvalidPasswordException("Current password is incorrect.");
        }

//        model.updateFromRequest(request);
        request.updateModel(model);
        userRepository.save(model);

        return new UserResponse(model);
    }

    @SneakyThrows
    public void changePassword(ChangePasswordRequest request) {
        Optional<User> optionalUser = this.userRepository.findByEmail(request.getNickname()); //Maybe nickname better
        if (optionalUser.isEmpty()) {
            throw new UserNotExistsException();
        }

        User user = optionalUser.get();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Current password is incorrect.");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }

    @SneakyThrows
    public UserResponse getUserById(String id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotExistsException();
        }

        return new UserResponse(optionalUser.get());
    }

    @SneakyThrows
    public UserWithPasswordResponse getUserByUsername(String nickname)
    {
        Optional<User> optionalUser = this.userRepository.findByNickname(nickname);
        if (optionalUser.isPresent()) {
            return new UserWithPasswordResponse(optionalUser.get());
        }
        throw new UserNotExistsException();
    }

    public List<UserResponse> searchUsers(Optional<String> name, Optional<String> nickname, Optional<String> email) {
        List<User> users = userRepository.findAll();

        if (name.isPresent()) {
            if (name.get().contains(" ")) {
                String[] nameParts = name.get().split(" ");
                if (nameParts.length == 2) {
                    users = userRepository.findByNameAndLastName(nameParts[0], nameParts[1]);
                }
            } else {
                users = userRepository.findByName(name.get());
            }
        } else {
            // IF NAME IS NOT PRESENT, GET ALL USERS
            users = userRepository.findAll();
        }

        // FILTER BY NICKNAME IF PRESENT IN THE PARAMETERS
        if (nickname.isPresent()) {
            users = users.stream()
                    .filter(user -> user.getNickname().equalsIgnoreCase(nickname.get()))
                    .collect(Collectors.toList());
        }

        // FILTER BY EMAIL IF PRESENT IN THE PARAMETERS
        if (email.isPresent()) {
            users = users.stream()
                    .filter(user -> user.getEmail().equalsIgnoreCase(email.get()))
                    .collect(Collectors.toList());
        }

        return users.stream().map(UserResponse::new).collect(Collectors.toList());
    }


    @SneakyThrows
    public void deleteById(String id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotExistsException();
        }

        this.userRepository.delete(id);
//        this.userRepository.delete(optionalUser.get());
    }

    private Role findRoleByName(String roleName) throws RoleNotExistsException {
        return roleRepository.findById(roleName)
                .orElseThrow(() -> new RoleNotExistsException("Role not found with name: " + roleName));
    }

    public boolean isTokenValid(String token, String endpoint)
    {
        String username = this.jwtTokenUtil.getKey(token); // TODO for logging purposes
        // Agregar la Dependencia de SLF4J
        // Register the logger
        //  logger.info("User '{}' with role '{}' is attempting to access endpoint '{}'", username, role, endpoint);
        String role = this.jwtTokenUtil.getValue(token);

        return this.roleRepository.isRoleEndpointtEnable(role, endpoint);
    }
}