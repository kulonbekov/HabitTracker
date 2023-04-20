package com.example.habittracker.mappers;

import com.example.habittracker.models.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.User;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto>{

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
