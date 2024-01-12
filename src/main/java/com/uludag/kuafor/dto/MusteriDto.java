package com.uludag.kuafor.dto;


import com.uludag.kuafor.entity.Gorev;
import com.uludag.kuafor.entity.Randevu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


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
    private List<Randevu> randevu;
//    private Rol rol;
    private Gorev gorev;
}