package com.manopata.api.roles.interfaces.dbo;

import com.manopata.api.roles.interfaces.models.Role;
import com.manopata.api.roles.interfaces.queries.RoleQueries;
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
    private JpaRoleRepository roleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public RoleDbo(
            JpaRoleRepository roleRepository
    ) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findById(String name) {
        return this.roleRepository.findById(name);
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public boolean isRoleEndpointtEnable(String role, String endpoint)
    {
        String query = RoleQueries.CHECK_TOKEN_PERMISSION;
        Number counter = (Number) entityManager.createNativeQuery(query)
                .setParameter("role", role)
                .setParameter("endpoint", endpoint)
                .getSingleResult();

        return counter.intValue() > 0;
    }
}
