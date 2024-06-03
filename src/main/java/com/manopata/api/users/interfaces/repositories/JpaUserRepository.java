package com.manopata.api.users.interfaces.repositories;

import com.manopata.api.users.interfaces.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository <User, String> {
    List<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findByNameAndLastname(String name, String lastname);
    Optional<User> findByNickname(String nickname);
}
