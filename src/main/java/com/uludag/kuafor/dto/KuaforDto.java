package com.uludag.kuafor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KuaforDto {
    private Long id;
    private String kullanici_adi;
    private String sifre;
    private String ad;
    private String soyad;
    private LocalTime baslangicSaati;
    private LocalTime bitisSaati;
}
