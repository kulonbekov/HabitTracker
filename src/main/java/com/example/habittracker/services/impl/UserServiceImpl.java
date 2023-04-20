package com.example.habittracker.services.impl;

import com.example.habittracker.models.dtos.UserDto;
import com.example.habittracker.services.UserService;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public UserDto register(UserDto userDto) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
