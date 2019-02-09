package com.example.sample.service.impl;

import com.example.sample.dto.UserDTO;
import com.example.sample.model.User;
import com.example.sample.repository.UserRepository;
import com.example.sample.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.map(userRepository.findAll(), List.class);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return modelMapper.map(userRepository.findById(userId), UserDTO.class);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }
}
