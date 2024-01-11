//package com.uludag.kuafor.service.impl;
//
//import com.uludag.kuafor.dto.UserDto;
//import com.uludag.kuafor.entity.User;
//import com.uludag.kuafor.mapper.UserMapper;
//import com.uludag.kuafor.repository.UserRepository;
//import com.uludag.kuafor.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserImpl implements UserService {
//
//    private final UserRepository userRepository;
//    private final UserMapper userMapper;
//
//    @Autowired
//    public UserImpl(UserRepository userRepository ,UserMapper userMapper) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//    }
//
//    @Override
//    public UserDto getUserByKullanici_adi(String kullanici_adi) {
//        User user = userRepository.findByKullanici_adi(kullanici_adi);
//        if(user != null) {
//            return UserMapper.userToUserDto(user);
//        } else {
//            return null;
//        }
//    }
//
//
//}
