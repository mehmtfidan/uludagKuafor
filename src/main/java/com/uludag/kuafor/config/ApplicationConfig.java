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
    @Bean
    public UserDetailsService userDetailsService() {

        return id -> musteriRepository.findmusteriBy(Long.valueOf(id))
                .orElseThrow(()->new UsernameNotFoundException("Kullanıcı bulunamadı"));

    }
//    @SpringBootApplication
//    public class KuaforApplication {
//
//        @Bean
//        public UserDetailsService userDetailsService(KuaforRepository kuaforRepository) {
//
//            return id -> kuaforRepository.findKuaforBy(Long.valueOf(id))
//                    .map(kuafor -> User.withUsername(kuafor.getUsername())
//                            .password(kuafor.getSifre())
//                            .roles("KUAFÖR")  // Rolleri de ekleyin
//                            .build())
//                    .orElseThrow(() -> new UsernameNotFoundException("Kuaför bulunamadı"));
//        }
//
//    }




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
