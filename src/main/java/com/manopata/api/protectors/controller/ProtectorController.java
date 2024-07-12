package com.manopata.api.protectors.controller;

import com.manopata.api.protectors.dto.ProtectorRequest;
import com.manopata.api.protectors.dto.ProtectorResponse;
import com.manopata.api.protectors.service.ProtectorService;
import com.manopata.api.protectors.exceptions.ResourceNotFoundException;
import com.manopata.api.protectors.model.Protector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/protectors")
public class ProtectorController {
    @Autowired
    private ProtectorService protectorService;

    @GetMapping
    public List<ProtectorResponse> getAllProtectors() {
        return protectorService.getAllProtectors();
    }

    @PostMapping
    public ProtectorResponse createProtector(@RequestBody ProtectorRequest protectorRequest) {
        return protectorService.saveProtector(protectorRequest);
    }

    @PutMapping("/{id}")
    public ProtectorResponse updateProtector(@PathVariable String id, @RequestBody ProtectorRequest protectorRequest) {
        return protectorService.updateProtector(UUID.fromString(id), protectorRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProtector(@PathVariable String id) {
        protectorService.deleteProtector(UUID.fromString(id));
    }

//    @GetMapping
//    public List<Protector> getAllProtectors() {
//        return protectorService.getAllProtectors();
//    }
//
//    @PostMapping
//    public Protector createProtector(@RequestBody Protector protector) {
//        return protectorService.saveProtector(protector);
//    }
//
//    @PutMapping("/{id}")
//    public Protector updateProtector(@PathVariable String id, @RequestBody Protector protectorDetails) {
//        Optional<Protector> optionalProtector = protectorService.getProtectorById(String.valueOf(UUID.fromString(id)));
//        if (optionalProtector.isPresent()) {
//            Protector protector = optionalProtector.get();
//            protector.setName(protectorDetails.getName());
//            protector.setDescription(protectorDetails.getDescription());
//            protector.setPhone(protectorDetails.getPhone());
//            protector.setEmail(protectorDetails.getEmail());
//            return protectorService.saveProtector(protector);
//        } else {
//            throw new ResourceNotFoundException("Protector not found with id " + id);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProtector(@PathVariable String id) {
//        protectorService.deleteProtector(String.valueOf(UUID.fromString(id)));
//    }
}
