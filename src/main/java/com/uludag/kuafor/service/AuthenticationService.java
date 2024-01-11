package com.uludag.kuafor.service;


import com.uludag.kuafor.auth.AuthenticationRequest;
import com.uludag.kuafor.auth.AuthenticationResponse;
import com.uludag.kuafor.auth.RegisterRequest;
import com.uludag.kuafor.entity.User;
import com.uludag.kuafor.entity.Gorev;
import com.uludag.kuafor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .ad(request.getAd())
                .soyad(request.getSoyad())
                .kullanici_adi(request.getKullanici_adi())
                .sifre(passwordEncoder.encode(request.getSifre()))
                .gorev(Gorev.musteri)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
//        var refreshToken = jwtService.generateRefreshToken(user);
//        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
//                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getKullanici_adi(),
                        request.getSifre()
                )
        );
        var user = userRepository.findByEmail(request.getKullanici_adi())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
//        var refreshToken = jwtService.generateRefreshToken(user);
//        revokeAllUserTokens(user);
//        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
//                .refreshToken(refreshToken)
                .build();
    }
}
