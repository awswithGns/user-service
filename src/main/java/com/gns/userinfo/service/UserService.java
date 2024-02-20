package com.gns.userinfo.service;

import com.gns.userinfo.dto.UserDTO;
import com.gns.userinfo.entity.User;
import com.gns.userinfo.mapper.UserMapper;
import com.gns.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User addedUser= userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));

        System.out.println(addedUser);
        return UserMapper.INSTANCE.mapUserToUserDTO(addedUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(int userId) {
        Optional<User> user= userRepo.findById(userId);

        return user.map(value -> new ResponseEntity<>
                (UserMapper.INSTANCE.mapUserToUserDTO(value), HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }
}
