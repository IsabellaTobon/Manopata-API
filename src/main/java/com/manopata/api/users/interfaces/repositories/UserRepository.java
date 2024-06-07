package com.manopata.api.users.interfaces.repositories;

import com.manopata.api.users.interfaces.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User model);
    void delete(String id);
    Optional<User> findById(String id);
    List<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByNickname(String nickname);
    List<User> findByNameAndLastName(String name, String lastName);
    List<User> findAll();
}
