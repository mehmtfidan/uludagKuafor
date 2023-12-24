package com.uludag.kuafor.mapper;

import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;

public class RandevuMapper {
    public static RandevuDto mapRandevuDto(Randevu randevu){
        return new RandevuDto(
            randevu.getId(), 
            randevu.getMusteriId(), 
            randevu.getKuafor(), 
            randevu.getIslemler(),
            randevu.getMusteriNotu(), 
            randevu.getRandevuSaati(),
            randevu.getRandevuGunu()
        );
    }
    public static Randevu maptoRandevu(RandevuDto randevuDto){
        return new Randevu(
            randevuDto.getId(), 
            randevuDto.getMusteriId(), 
            randevuDto.getKuafor(), 
            randevuDto.getIslemler(),
            randevuDto.getMusteriNotu(), 
            randevuDto.getRandevuSaati(),
            randevuDto.getRandevuGunu()
        );
    }
}