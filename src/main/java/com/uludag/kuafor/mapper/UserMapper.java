//package com.uludag.kuafor.mapper;
//
//
//
//
//import com.uludag.kuafor.dto.UserDto;
//import com.uludag.kuafor.entity.User;
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//
//public class UserMapper  {
//
//    public UserDto toDto(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setKullanici_adi(user.getKullanici_adi());
//        userDto.setSifre(user.getSifre());
//        userDto.setRole(user.getRole());
//        // Diğer alanlar dönüşümü
//        return userDto;
//    }
//
//    public User toEntity(UserDto userDto) {
//        User user = new User();
//        user.setKullanici_adi(userDto.getKullanici_adi());
//        user.setSifre(userDto.getSifre());
//        user.setRole(userDto.getRole());
//        // Diğer alanlar dönüşümü
//        return user;
//    }
//}
