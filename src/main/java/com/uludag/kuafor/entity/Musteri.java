package com.uludag.kuafor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uludag.kuafor.repository.RandevuRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Musteri")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;
    @JsonIgnore
    private String kullanici_adi;
    @JsonIgnore
    private String sifre;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

}
