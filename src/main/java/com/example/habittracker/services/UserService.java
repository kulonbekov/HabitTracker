package com.example.habittracker.services;

import com.example.habittracker.models.dtos.UserDto;
import com.example.habittracker.models.entities.User;


import java.util.List;

public interface UserService {
    UserDto register(UserDto userDto);

    List<User> getAll();

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);

    void delete(Long id);
}
