package com.uludag.kuafor.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.entity.Randevu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.uludag.kuafor.entity.Rol;

import java.time.LocalTime;
import java.util.List;


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
    private Rol rol;

}
