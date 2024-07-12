package com.manopata.api.protectors.service;

import com.manopata.api.protectors.dto.ProtectorRequest;
import com.manopata.api.protectors.dto.ProtectorResponse;
import com.manopata.api.protectors.exceptions.ResourceNotFoundException;
import com.manopata.api.protectors.model.Protector;
import com.manopata.api.protectors.repository.ProtectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProtectorService {
    @Autowired
    private ProtectorRepository protectorRepository;

    public List<ProtectorResponse> getAllProtectors() {
        return protectorRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public ProtectorResponse saveProtector(ProtectorRequest protectorRequest) {
        Protector protector = new Protector();
        protector.setName(protectorRequest.getName());
        protector.setDescription(protectorRequest.getDescription());
        protector.setPhone(protectorRequest.getPhone());
        protector.setEmail(protectorRequest.getEmail());
        Protector savedProtector = protectorRepository.save(protector);
        return convertToResponse(savedProtector);
    }

    public ProtectorResponse updateProtector(UUID id, ProtectorRequest protectorRequest) {
        Optional<Protector> optionalProtector = protectorRepository.findById(id);
        if (optionalProtector.isPresent()) {
            Protector protector = optionalProtector.get();
            protector.setName(protectorRequest.getName());
            protector.setDescription(protectorRequest.getDescription());
            protector.setPhone(protectorRequest.getPhone());
            protector.setEmail(protectorRequest.getEmail());
            Protector updatedProtector = protectorRepository.save(protector);
            return convertToResponse(updatedProtector);
        } else {
            throw new ResourceNotFoundException("Protector not found with id " + id);
        }
    }

    public void deleteProtector(UUID id) {
        protectorRepository.deleteById(id);
    }

    private ProtectorResponse convertToResponse(Protector protector) {
        ProtectorResponse response = new ProtectorResponse();
        response.setId(protector.getId().toString());
        response.setName(protector.getName());
        response.setDescription(protector.getDescription());
        response.setPhone(protector.getPhone());
        response.setEmail(protector.getEmail());
        return response;
    }

//    public List<Protector> getAllProtectors() {
//        return protectorRepository.findAll();
//    }
//
//    public Protector saveProtector(Protector protector) {
//        return protectorRepository.save(protector);
//    }
//
//    public Optional<Protector> getProtectorById(String id) {
//        return protectorRepository.findById(id);
//    }
//
//    public void deleteProtector(String id) {
//        protectorRepository.deleteById(id);
//    }
}
