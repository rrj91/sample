package com.example.sample.service;

import com.example.sample.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getAllRoles();

    RoleDTO getRoleById(Long roleId);

    RoleDTO addRole(RoleDTO roleDTO);
}
