package com.uludag.kuafor.mapper;

import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;

public class RandevuMapper {
    public static RandevuDto mapRandevuDto(Randevu randevu){
        return new RandevuDto(
            randevu.getId(), 
            randevu.getMusteriId(), 
            randevu.getKuafor_id(), 
            randevu.getHizmet(),
            randevu.getMusteriNotu(), 
            randevu.getRandevuSaati(),
            randevu.getRandevuGunu()
        );
    }
    public static Randevu maptoRandevu(RandevuDto randevuDto){
        return new Randevu(
            randevuDto.getId(), 
            randevuDto.getMusteriId(), 
            randevuDto.getKuafor_id(), 
            randevuDto.getHizmet(),
            randevuDto.getMusteriNotu(), 
            randevuDto.getRandevuSaati(),
            randevuDto.getRandevuGunu()
        );
    }
}