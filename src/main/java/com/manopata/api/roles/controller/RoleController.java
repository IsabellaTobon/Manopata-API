package com.manopata.api.roles.controller;

import com.manopata.api.roles.interfaces.models.Role;
import com.manopata.api.roles.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Role> getRoleById(@PathVariable String name) {
        Optional<Role> role = roleService.findById(name);
        return role.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<Void> deleteRoleByName(@PathVariable String name) {
        roleService.deleteById(name);
        return ResponseEntity.noContent().build();
    }
}
