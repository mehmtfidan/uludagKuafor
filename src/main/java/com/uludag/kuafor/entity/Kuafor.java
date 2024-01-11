package com.uludag.kuafor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Kuafor")
public class Kuafor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private String kullanici_adi;
    @JsonIgnore
    private String sifre;
    private String ad;
    private String soyad;
    private LocalTime baslangic_saati;
    private LocalTime bitis_saati;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

}

