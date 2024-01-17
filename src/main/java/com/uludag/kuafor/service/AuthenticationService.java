//package com.uludag.kuafor.service;
//
//import com.uludag.kuafor.auth.AuthenticationRequest;
//import com.uludag.kuafor.auth.AuthenticationResponse;
//import com.uludag.kuafor.auth.RegisterRequest;
//import com.uludag.kuafor.entity.Gorev;
//import com.uludag.kuafor.entity.Musteri;
//import com.uludag.kuafor.repository.KuaforRepository;
//import com.uludag.kuafor.repository.MusteriRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationService {
//    private final MusteriRepository musteriRepository;
//  private final KuaforRepository kuaforRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthenticationResponse register(RegisterRequest request) {
//        var encryptedPassword = passwordEncoder.encode(request.getSifre());
//        var user = Musteri.builder()
//                .ad(request.getAd())
//                .soyad(request.getSoyad())
//                .kullanici_adi(request.getKullanici_adi())
//                .sifre(encryptedPassword)
//                .gorev(Gorev.musteri)
//                .build();
//        musteriRepository.save(user);
//
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .accessToken(jwtToken)
//                .build();
//    }
//
//
//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getKullanici_adi(),
//                        request.getSifre()
//                )
//        );
//        var musteri =musteriRepository.findmusteriBy(request.getId())
////        var user = userRepository.findUserById(request.getId())
//                .orElseThrow();
//        var jwtToken = jwtService.generateToken(musteri);
//        return AuthenticationResponse.builder()
//                .accessToken(jwtToken)
//                .build();
//    }
//}


package com.uludag.kuafor.service;

import com.uludag.kuafor.auth.AuthenticationRequest;
import com.uludag.kuafor.auth.AuthenticationResponse;
import com.uludag.kuafor.auth.RegisterRequest;
import com.uludag.kuafor.entity.Gorev;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.repository.KuaforRepository;
import com.uludag.kuafor.repository.MusteriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final MusteriRepository musteriRepository;
    private final KuaforRepository kuaforRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var encryptedPassword = passwordEncoder.encode(request.getSifre());
        var user = Kuafor.builder()
                .ad(request.getAd())
                .soyad(request.getSoyad())
                .kullanici_adi(request.getKullanici_adi())
                .sifre(encryptedPassword)
                .gorev(Gorev.kuafor)
                .build();
        kuaforRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
    public AuthenticationResponse register1(RegisterRequest request) {
        var encryptedPassword = passwordEncoder.encode(request.getSifre());
        var user = Musteri.builder()
                .ad(request.getAd())
                .soyad(request.getSoyad())
                .kullanici_adi(request.getKullanici_adi())
                .sifre(encryptedPassword)
                .gorev(Gorev.musteri)
                .build();
        musteriRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }






    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getKullanici_adi(),
                        request.getSifre()
                )
        );
        var kuafor = kuaforRepository.findKuaforBy(request.getId())
//        var user = userRepository.findUserById(request.getId())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(kuafor);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }


}
