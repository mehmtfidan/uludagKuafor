package com.uludag.kuafor.dto;

import com.uludag.kuafor.entity.Gorev;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    private Long id;
    private String kullanici_adi;
    private String sifre;
    private String token;
    private Long rolId;


    private Gorev gorev;

    public AdminDto(Long id, String kullaniciAdi, String sifre, String token, Gorev gorev) {
    }
}
