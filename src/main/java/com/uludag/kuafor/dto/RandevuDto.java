package com.uludag.kuafor.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uludag.kuafor.entity.Musteri;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalTime;

import com.uludag.kuafor.entity.Kuafor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RandevuDto {
    
    private Long Id;
    @JsonIgnore
    private Musteri musteri;
    @JsonIgnore
    private Kuafor kuafor;
    private Long musteriId;
    private Long kuaforId;
    private String musteriNotu;
    private LocalTime randevuSaati;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date randevuGunu;
    private String randevuDurumu;
    private String hizmetler;

    public RandevuDto(Long Id, Long musteriId, Long kuaforId, String musteriNotu, LocalTime randevuSaati,
                      Date randevuGunu, String randevuDurumu, String hizmetler) {
        this.Id = Id;
        this.musteriId = musteriId;
        this.kuaforId = kuaforId;
        this.musteriNotu = musteriNotu;
        this.randevuSaati = randevuSaati;
        this.randevuGunu = randevuGunu;
        this.randevuDurumu = randevuDurumu;
        this.hizmetler = hizmetler;
    }
}