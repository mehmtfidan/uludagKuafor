package com.uludag.kuafor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Musteri")
public class Musteri implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String ad;
    private String soyad;
    @JsonIgnore
    private String kullanici_adi;
    @JsonIgnore
    private String sifre;
    @ManyToMany
    private List<Randevu> randevu;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
    @Column(insertable=false, updatable=false)
    private Long rol_id;



    @JoinColumn(name = "gorev_id")
    @Enumerated(EnumType.STRING)
    private Gorev gorev;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return List.of(new SimpleGrantedAuthority((gorev.name())));
    }

    @Override
    public String getPassword() {
        return sifre;
    }

    @Override
    public String getUsername() {
        return kullanici_adi;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}



