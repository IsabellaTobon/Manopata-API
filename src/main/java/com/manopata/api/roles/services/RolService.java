package com.manopata.api.roles.services;

import com.manopata.api.roles.dto.RolResponse;
import com.manopata.api.roles.interfaces.models.Rol;
import com.manopata.api.roles.interfaces.repositories.RolRepository;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    private RolRepository rolRepository;

    public RolService(RolRepository rolRepository) { this.rolRepository = rolRepository ;}

    @SneakyThrows
    public RolResponse

}
