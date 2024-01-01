package com.uludag.kuafor.mapper;

import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.entity.Kuafor;

public class KuaforMapper {
    public static KuaforDto mapToKuaforDto(Kuafor kuafor){
        return new KuaforDto(
                kuafor.getId(), kuafor.getKullanici_adi(), kuafor.getSifre(), kuafor.getAd(),kuafor.getSoyad(), kuafor.getHizmetKuafor(), kuafor.getRandevular(), kuafor.getBaslangic_saati(),kuafor.getBitis_saati()
        );
    }
    public static Kuafor mapToKuafor(KuaforDto kuaforDto){
        return new Kuafor(
                kuaforDto.getId(), kuaforDto.getKullanici_adi(), kuaforDto.getSifre(), kuaforDto.getAd(),kuaforDto.getSoyad(), kuaforDto.getHizmetKuafor(), kuaforDto.getRandevular(), kuaforDto.getBaslangic_saati(),kuaforDto.getBitis_saati()
        );
    }
}
