package com.uludag.kuafor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RandevuDto {
    
    private Long id;    
    private Long musteriId;
    private Long kuaforId;
    private String islemler;
    private String musteriNotu;
    private LocalTime randevuSaati;
    private Date randevuGunu;
}