package com.uludag.kuafor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Kuafor")
public class Kuafor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String kullaniciAdi;
    @Column(nullable = false, unique = true)
    private String sifre;
    @Column(nullable = false, unique = true)
    private String ad;
    @Column(nullable = false, unique = true)
    private String soyad;
    private LocalTime baslangicSaati;
    private LocalTime bitisSaati;
}
