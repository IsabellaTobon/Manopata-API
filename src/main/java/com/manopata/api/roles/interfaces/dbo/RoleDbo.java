package com.manopata.api.roles.interfaces.dbo;

import com.manopata.api.roles.interfaces.models.Role;
import com.manopata.api.roles.interfaces.repositories.JpaRoleRepository;
import com.manopata.api.roles.interfaces.repositories.RoleRepository;
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
public class RoleDbo implements RoleRepository {
    private final JpaRoleRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public RoleDbo(JpaRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role model) {
        return this.repository.save(model);
    }

    @Override
    public void delete(String name) {
        this.repository.deleteById(name);
    }

    @Override
    public Optional<Role> findById(String name) {
        return this.repository.findById(name);
    }

    @Override
    public List<Role> findAll() {
        return this.repository.findAll();
    }
}
