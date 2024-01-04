package com.uludag.kuafor.mapper;

import com.uludag.kuafor.dto.MusteriDto;

import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.entity.Randevu;

import java.util.List;

public class MusteriMapper {
    public static MusteriDto mapToMusteriDto(Musteri musteri) {
        return new MusteriDto(
                musteri.getId(), musteri.getAd(), musteri.getSoyad(), musteri.getKullanici_adi(), musteri.getSifre(), (List<Randevu>) musteri.getRandevu(),musteri.getRol()
        );

    }

    public static Musteri mapToMusteri(MusteriDto musteriDto) {
        return new Musteri(
                musteriDto.getId(), musteriDto.getAd(), musteriDto.getSoyad(), musteriDto.getKullanici_adi(), musteriDto.getSifre(), (List<Randevu>) musteriDto.getRandevu(), musteriDto.getRol()
        );

    }
}
