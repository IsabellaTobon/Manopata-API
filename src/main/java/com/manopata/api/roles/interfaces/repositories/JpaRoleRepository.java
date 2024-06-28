package com.manopata.api.roles.interfaces.repositories;

import com.manopata.api.roles.interfaces.models.Role;
import com.manopata.api.roles.interfaces.models.RoleEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JpaRoleRepository extends JpaRepository<Role, String>
{
}
