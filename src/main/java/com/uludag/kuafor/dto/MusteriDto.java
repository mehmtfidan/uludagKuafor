package com.uludag.kuafor.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class MusteriDto {
    private Long id;
    private String ad;
    private String soyad;
    private String kullanici_adi;
    private String sifre;

}