package com.uludag.kuafor.controller;

import com.uludag.kuafor.dto.UserDto;
import com.uludag.kuafor.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/User")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("{/kullanici_adi}")
    public ResponseEntity<UserDto> getUserByKullanici_adi(@PathVariable String kullanici_adi) {
        UserDto userDto = userService.getUserByKullanici_adi(kullanici_adi);
        if(userDto != null)  {
            return new ResponseEntity<>(userDto , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
