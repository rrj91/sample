package com.example.sample.service.impl;

import com.example.sample.dto.RoleDTO;
import com.example.sample.model.Role;
import com.example.sample.repository.RoleRepository;
import com.example.sample.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<RoleDTO> getAllRoles() {
        return mapper.map(roleRepository.findAll(), List.class);
    }

    @Override
    public RoleDTO getRoleById(Long roleId) {
        return mapper.map(roleRepository.findById(roleId), RoleDTO.class);
    }

    @Override
    public RoleDTO addRole(RoleDTO roleDTO) {
        Role role = mapper.map(roleDTO, Role.class);
        return mapper.map(roleRepository.save(role), RoleDTO.class);
    }
}
