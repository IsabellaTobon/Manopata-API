package com.manopata.api.users.interfaces.dbo;

import com.manopata.api.users.interfaces.repositories.JpaUserRepository;
import com.manopata.api.users.interfaces.repositories.UserRepository;
import com.manopata.api.users.interfaces.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@Transactional
public class UserDbo implements UserRepository {

    private JpaUserRepository repository;

    @PersistenceContext
    public EntityManager entityManager;

    public UserDbo(JpaUserRepository repository) { this.repository = repository; }

    @Override
    public User save(User model) {
        return this.repository.save(model);
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<User> findByName(String name) {
        return this.repository.findByName(name);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        return this.repository.findByNickname(nickname);
    }

    @Override
    public List<User> findByNameAndLastName(String name, String lastName) {
        return this.repository.findByNameAndLastname(name, lastName);
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

}
