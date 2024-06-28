package com.manopata.api.users.services;

import com.manopata.api.roles.exceptions.RoleNotExistsException;
import com.manopata.api.roles.interfaces.models.Role;
import com.manopata.api.roles.interfaces.repositories.RoleRepository;
import com.manopata.api.users.dto.UserRequest;
import com.manopata.api.users.dto.UserResponse;
import com.manopata.api.users.dto.UserWithPasswordResponse;
import com.manopata.api.users.exceptions.UserEmailExistsException;
import com.manopata.api.users.exceptions.UserEmailNotExistsException;
import com.manopata.api.users.exceptions.UserNicknameExistsException;
import com.manopata.api.users.exceptions.UserNotExistsException;
import com.manopata.api.users.interfaces.repositories.UserRepository;
import com.manopata.api.users.interfaces.models.User;

import com.manopata.api.utlis.auth.JwtTokenUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @SneakyThrows
    public UserResponse create(UserRequest request) {
        if (this.userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserEmailExistsException();
        }

        if (this.userRepository.findByNickname(request.getNickname()).isPresent()) {
            throw new UserNicknameExistsException();
        }
        Role role = findRoleByName(request.getRoleName());
        String id = UUID.randomUUID().toString();
        User model = this.userRepository.save(request.toModel(id, role));
        return new UserResponse(model);
    }

    @SneakyThrows
    public UserResponse update(UserRequest request) {
        Optional<User> optionalUser = this.userRepository.findByEmail(request.getEmail());
        if (optionalUser.isEmpty()) {
            throw new UserEmailNotExistsException();
        }

        User model = optionalUser.get();
        userRepository.save(model);

        return new UserResponse(model);
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
        if (optionalUser.isPresent()) { return new UserWithPasswordResponse(optionalUser.get()); }
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
        String role = this.jwtTokenUtil.getValue(token);

        return this.roleRepository.isRoleEndpointtEnable(role, endpoint);
    }
}