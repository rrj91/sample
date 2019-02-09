package com.example.sample.controller;

import com.example.sample.dto.RoleDTO;
import com.example.sample.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = roleService.getAllRoles();
        if (roles != null && !roles.isEmpty())
            return new ResponseEntity(roles, HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO roleDTO) {
        return new ResponseEntity(roleService.addRole(roleDTO), HttpStatus.OK);
    }
}
