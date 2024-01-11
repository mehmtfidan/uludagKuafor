package com.uludag.kuafor.auth;

import com.uludag.kuafor.entity.Gorev;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String ad;
    private String soyad;
    private String kullanici_adi;
    private String sifre;
    private Gorev gorev;

}
