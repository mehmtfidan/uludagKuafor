package com.uludag.kuafor.mapper;

import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.entity.Kuafor;

public class KuaforMapper {
    public static KuaforDto mapToKuaforDto(Kuafor kuafor){
        return new KuaforDto(
                kuafor.getId(), kuafor.getKullaniciAdi(), kuafor.getSifre(), kuafor.getAd(),kuafor.getSoyad(), kuafor.getBaslangicSaati(),kuafor.getBitisSaati()
        );
    }
    public static Kuafor mapToKuafor(KuaforDto kuaforDto){
        return new Kuafor(
                kuaforDto.getId(), kuaforDto.getKullaniciAdi(), kuaforDto.getSifre(), kuaforDto.getAd(),kuaforDto.getSoyad(), kuaforDto.getBaslangicSaati(),kuaforDto.getBitisSaati()
        );
    }
}
