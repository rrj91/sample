package com.example.sample.service;

import com.example.sample.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long userId);

    UserDTO addUser(UserDTO userDTO);
}
