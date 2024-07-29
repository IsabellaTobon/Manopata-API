package com.manopata.api.protectors.repository;

import com.manopata.api.protectors.models.Protector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProtectorRepository extends JpaRepository<Protector, UUID> {
    Optional<Protector> findByName(String name);
}
