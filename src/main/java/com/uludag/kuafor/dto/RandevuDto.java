package com.uludag.kuafor.dto;

import com.uludag.kuafor.entity.Musteri;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalTime;

import com.uludag.kuafor.entity.Kuafor;

@Getter
@Setter
@AllArgsConstructor

public class RandevuDto {
    
    private Long Id;
    private Musteri musteri;
    private Kuafor kuafor;
    private Long musteriId;
    private Long kuaforId;
    private String musteriNotu;
    private LocalTime randevuSaati;
    private Date randevuGunu;
}