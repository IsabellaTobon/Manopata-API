package com.manopata.api.roles.interfaces.repositories;

import com.manopata.api.roles.interfaces.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {

    Optional<Role> findById(String name);
    List<Role> findAll();
}
