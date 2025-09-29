package com.exist.helpdesk.controller;

import com.exist.helpdesk.service.RoleService;
import com.exist.helpdesk.dto.RoleRequestDTO;
import com.exist.helpdesk.dto.RoleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleResponseDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public RoleResponseDTO getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    public RoleResponseDTO createRole(@RequestBody RoleRequestDTO request) {
        return roleService.createRole(request);
    }

    @PutMapping("/{id}")
    public RoleResponseDTO updateRole(@PathVariable Long id, @RequestBody RoleRequestDTO request) {
        return roleService.updateRole(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
