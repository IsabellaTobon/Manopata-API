package com.manopata.api.protectors.repository;

import com.manopata.api.protectors.model.Protector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProtectorRepository extends JpaRepository<Protector, UUID> {
}
