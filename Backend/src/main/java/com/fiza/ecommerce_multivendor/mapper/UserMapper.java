package com.fiza.ecommerce_multivendor.mapper;

import com.fiza.ecommerce_multivendor.dto.UserDto;
import com.fiza.ecommerce_multivendor.model.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
