package com.example.habittracker.services.impl;

import com.example.habittracker.mappers.UserMapper;
import com.example.habittracker.models.dtos.UserDto;
import com.example.habittracker.models.entities.Role;
import com.example.habittracker.models.entities.User;
import com.example.habittracker.models.enums.Status;
import com.example.habittracker.repository.RoleRep;
import com.example.habittracker.repository.UserRep;
import com.example.habittracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRep userRep;
    private final RoleRep roleRep;
    private final PasswordEncoder passwordEncoder;
    private UserMapper userMapper = UserMapper.INSTANCE;
    @Override
    public UserDto register(UserDto userDto) {
        return userMapper.toDto(userRep.save(userMapper.toEntity(userDto)));
    }

    @Override
    public List<User> getAll() {
        return userRep.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRep.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRep.findByEmail(email);
    }

    @Override
    public User findById(Long id) {
        return userRep.findById(id).orElseThrow(() -> new RuntimeException("User is not found"));
    }

    @Override
    public void delete(Long id) {
        userRep.deleteById(id);
    }

    private User toEntity(UserDto userDto) {

        Role roleUser = roleRep.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setAge(userDto.getAge());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        return user;
    }
}
