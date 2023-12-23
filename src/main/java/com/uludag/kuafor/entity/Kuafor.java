package com.uludag.kuafor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"id", "kullaniciAdi","sifre"})
@Table(name = "Kuafor")
public class Kuafor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kullaniciAdi;
    private String sifre;
    private String ad;
    private String soyad;
    private LocalTime baslangicSaati;
    private LocalTime bitisSaati;
}
