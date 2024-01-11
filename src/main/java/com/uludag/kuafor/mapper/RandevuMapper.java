package com.uludag.kuafor.mapper;

import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;

public class RandevuMapper {
    public static RandevuDto mapRandevuDto(Randevu randevu){
        return new RandevuDto(
                randevu.getId(),
                randevu.getMusteri(),
                randevu.getKuafor(),
                randevu.getMusteri().getId(),
                randevu.getKuafor().getId(),
                randevu.getMusteriNotu(),
                randevu.getRandevuSaati(),
                randevu.getRandevuGunu(),
                randevu.getRandevuDurumu(),
                randevu.getHizmetler()
        );
    }
    public static Randevu maptoRandevu(RandevuDto randevuDto){
        return new Randevu(
                randevuDto.getId(),
                randevuDto.getMusteri(),
                randevuDto.getKuafor(),
                randevuDto.getMusteriNotu(),
                randevuDto.getRandevuSaati(),
                randevuDto.getRandevuGunu(),
                randevuDto.getRandevuDurumu(),
                randevuDto.getHizmetler()
        );
    }

}