package com.example.simpleroot.controller;

import com.example.simpleroot.dto.UserDTO;
import com.example.simpleroot.entity.User;
import com.example.simpleroot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<UserDTO> getUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO) {
        return userService.deleteUser(userDTO) ;
    }

    @GetMapping("/getUserByUserId/{userId}")
    public UserDTO getUserById(@PathVariable String userId){
      return   userService.getUserByUserId(userId);
    }
}
