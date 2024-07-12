package com.manopata.api.protectors.controller;

import com.manopata.api.protectors.dto.ProtectorRequest;
import com.manopata.api.protectors.dto.ProtectorResponse;
import com.manopata.api.protectors.exceptions.ProtectorNotFoundException;
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

    @GetMapping("/byname/{name}")
    public ProtectorResponse getProtectorByName(@PathVariable String name) {
        Optional<ProtectorResponse> optionalProtector = protectorService.getProtectorByName(name);
        return optionalProtector.orElseThrow(() -> new ProtectorNotFoundException("Protector not found with name: " + name));
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

}
