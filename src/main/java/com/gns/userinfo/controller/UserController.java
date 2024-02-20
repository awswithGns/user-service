package com.gns.userinfo.controller;

import com.gns.userinfo.dto.UserDTO;
import com.gns.userinfo.service.UserService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO)
    {
        UserDTO addUserDTO=userService.addUser(userDTO);

        return new ResponseEntity<>(addUserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable int userId)
    {
       return userService.fetchUserById(userId);
    }


}
