package com.uludag.kuafor.controller;

import com.uludag.kuafor.auth.AuthenticationRequest;
import com.uludag.kuafor.auth.AuthenticationResponse;
import com.uludag.kuafor.auth.RegisterRequest;
import com.uludag.kuafor.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register-kuafor")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/register-musteri")
    public ResponseEntity<AuthenticationResponse> register1(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register1(request));
    }

//    @PostMapping("/register-musteri")
//    public ResponseEntity<AuthenticationResponse> register2(
//            @RequestBody RegisterRequest request
//    ) {
//        return ResponseEntity.ok(authenticationService.register1(request));
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
