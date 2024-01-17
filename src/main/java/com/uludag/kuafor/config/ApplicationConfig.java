package com.uludag.kuafor.config;


import com.uludag.kuafor.repository.KuaforRepository;
import com.uludag.kuafor.repository.MusteriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final KuaforRepository kuaforRepository;
  private final MusteriRepository musteriRepository;
////    @Bean
////    public UserDetailsService userDetailsService() {
////
////        return id -> musteriRepository.findmusteriBy(Long.valueOf(id))
////                .map(musteri -> User.withUsername(musteri.getUsername())
////                            .password(musteri.getSifre())
////                            .roles("MUSTERI")
////                            .build())
////                .orElseThrow(()->new UsernameNotFoundException("Kullanıcı bulunamadı"));
////
////    }
@Bean
public UserDetailsService userDetailsService() {
    return musteri -> musteriRepository.findmusteriBy(Long.valueOf(musteri))
            .orElseThrow(() -> new UsernameNotFoundException("Kuafor not found"));
}

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return kuafor -> kuaforRepository.findKuaforBy(Long.valueOf(kuafor))
//                .orElseThrow(() -> new UsernameNotFoundException("Kuafor not found"));
//    }
//
//


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


