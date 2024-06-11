package com.manopata.api.roles.services;

import com.manopata.api.roles.interfaces.models.Role;
import com.manopata.api.roles.interfaces.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    public Optional<Role> findById(String name) {
        return roleRepository.findById(name);
    }

}
