package com.example.sample.controller;

import com.example.sample.dto.UserDTO;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity(userService.addUser(userDTO), HttpStatus.OK);
    }
}
