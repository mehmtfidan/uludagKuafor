package com.uludag.kuafor.dto;

import com.uludag.kuafor.entity.Gorev;
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
    private LocalTime baslangic_saati;
    private LocalTime bitis_saati;
//    private Rol rol;
    private Gorev gorev;
}
