package com.uludag.kuafor.service.impl;

import com.uludag.kuafor.dto.MusteriDto;
import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.MusteriMapper;
import com.uludag.kuafor.repository.MusteriRepository;
import com.uludag.kuafor.service.MusteriService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MusteriImpl implements MusteriService
{
    MusteriRepository musteriRepository;

    @Override
    public MusteriDto musteriEkle(MusteriDto musteriDto) {
        Musteri musteri = MusteriMapper.mapToMusteri(musteriDto);
        Musteri kaydedilmisMusteri = musteriRepository.save(musteri);
        return MusteriMapper.mapToMusteriDto(kaydedilmisMusteri);
    }

    @Override
    public MusteriDto idIleGetir(Long Id) {
        Musteri musteri = musteriRepository.findById(Id)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir müsteri bulunamadi." ));
        return MusteriMapper.mapToMusteriDto(musteri);
    }

    @Override
    public List<MusteriDto> musteriGoster() {
        List<Musteri> musteriler = musteriRepository.findAll();
        return musteriler.stream().map((musteri) -> MusteriMapper.mapToMusteriDto(musteri))
                .collect(Collectors.toList());
    }

    @Override
    public MusteriDto musteriGuncelle(Long Id, MusteriDto guncellenenMusteri) {
        Musteri musteri = musteriRepository.findById(Id)
                .orElseThrow(()->new KaynakBulunamadiException("Bu id ile kayitli bir musteri bulunamadi. Id: " ));

        musteri.setAd(guncellenenMusteri.getAd());
        musteri.setSoyad(guncellenenMusteri.getSoyad());
        musteri.setKullanici_adi(guncellenenMusteri.getKullanici_adi());
        musteri.setSifre(guncellenenMusteri.getSifre());

        Musteri veritabanindaGuncellenmmisMusteri = musteriRepository.save(musteri);
        return MusteriMapper.mapToMusteriDto(veritabanindaGuncellenmmisMusteri);
    }

    @Override
    public void musteriSil(Long Id) {
        musteriRepository.findById(Id)
                .orElseThrow(() -> new KaynakBulunamadiException("Bu id ile kayitli bir musteri bulunamadi." ));
        musteriRepository.deleteById(Id);
    }
}