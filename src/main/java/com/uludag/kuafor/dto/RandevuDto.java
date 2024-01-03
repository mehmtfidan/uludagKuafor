package com.uludag.kuafor.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uludag.kuafor.entity.Musteri;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalTime;

import com.uludag.kuafor.entity.Kuafor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RandevuDto {
    
    private Long id;
    @JsonIgnore
    private Musteri musteri;
    @JsonIgnore
    private Kuafor kuafor;
    private Long musteriId;
    private Long kuaforId;
    private String musteriNotu;
    private LocalTime randevuSaati;
    private Date randevuGunu;
}