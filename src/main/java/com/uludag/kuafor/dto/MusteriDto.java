package com.uludag.kuafor.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uludag.kuafor.entity.Randevu;
import com.uludag.kuafor.entity.Rol;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

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
    private Rol rol;
}