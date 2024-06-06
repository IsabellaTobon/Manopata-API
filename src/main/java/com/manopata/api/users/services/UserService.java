package com.manopata.api.users.services;

import com.manopata.api.users.dto.UserRequest;
import com.manopata.api.users.dto.UserResponse;
import com.manopata.api.users.exceptions.UserEmailExistsException;
import com.manopata.api.users.exceptions.UserEmailNotExistsException;
import com.manopata.api.users.exceptions.UserNicknameExistsException;
import com.manopata.api.users.exceptions.UserNotExistsException;
import com.manopata.api.users.interfaces.repositories.UserRepository;
import com.manopata.api.users.interfaces.models.User;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    public UserResponse create(UserRequest request)
    {
        /*if (this.userRepository.findByEmail(request.getEmail()).isPresent())
        {
            throw new UserEmailExistsException();
        }

        if (this.userRepository.findByNickname(request.getNickname()).isPresent())
        {
            throw new UserNicknameExistsException();
        }
*/
        String id = UUID.randomUUID().toString();
        User model = this.userRepository.save(request.toModel(id));
        return new UserResponse(model);
    }

    @SneakyThrows
    public UserResponse update(UserRequest request)
    {
        Optional<User> optionalUser = this.userRepository.findByEmail(request.getEmail());
        if (optionalUser.isEmpty())
        {
            throw new UserEmailNotExistsException();
        }

        User model = optionalUser.get();
        model = this.userRepository.save(request.toModel(model.getId()));
        return new UserResponse(model);
    }

    @SneakyThrows
    public UserResponse getUserById(String id)
    {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty())
        {
            throw new UserNotExistsException();
        }

        return new UserResponse(optionalUser.get());
    }

    @SneakyThrows
    public boolean deleteById(String id)
    {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty())
        {
            throw new UserNotExistsException();
        }

        this.userRepository.delete(id);
        return true;
    }

}
