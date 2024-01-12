package com.uludag.kuafor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.RandevuMapper;
import com.uludag.kuafor.repository.KuaforRepository;
import com.uludag.kuafor.repository.MusteriRepository;
import org.springframework.stereotype.Service;

import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;
import com.uludag.kuafor.repository.RandevuRepository;
import com.uludag.kuafor.service.RandevuService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RandevuImpl implements RandevuService {

    RandevuRepository randevuRepository;
    MusteriRepository musteriRepository;
    KuaforRepository kuaforRepository;

    @Override
    public List<RandevuDto> randevuGoster() {
        List<Randevu> randevular = randevuRepository.findAll();
        return randevular.stream().map(randevu -> RandevuMapper.mapRandevuDto(randevu)).collect(Collectors.toList());
    }
    @Override
    @JsonIgnoreProperties({"randevuDurumu"})
    public Randevu randevuKaydet(Randevu randevu) {
        if (randevu.getRandevuDurumu()==null){
            randevu.setRandevuDurumu("Beklemede");
        }
        return randevuRepository.save(randevu);
    }

    @Override
    public RandevuDto idIleRandevuGoster(Long Id) {
        Randevu randevu = randevuRepository.findById(Id).orElseThrow(() -> new KaynakBulunamadiException("Kayıtlı randevu bulunamadı."));
        return RandevuMapper.mapRandevuDto(randevu);
    }

    @Override
    public RandevuDto randevuGuncelle(RandevuDto guncelRandevu) {
        Randevu randevu = randevuRepository.findById(guncelRandevu.getId()).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));
        Musteri musteri = musteriRepository.findById(guncelRandevu.getMusteriId()).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));
        Kuafor kuafor = kuaforRepository.findById(guncelRandevu.getKuaforId()).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));

        randevu.setMusteri(musteri);
        randevu.setKuafor(kuafor);
        randevu.setMusteriNotu(randevu.getMusteriNotu());
        randevu.setRandevuSaati(randevu.getRandevuSaati());
        randevu.setRandevuGunu(randevu.getRandevuGunu());
        randevu.setRandevuDurumu(Character.toUpperCase(randevu.getRandevuDurumu().charAt(0)) + randevu.getRandevuDurumu().substring(1));

        Randevu vtGuncellenmis = randevuRepository.save(randevu);
        return RandevuMapper.mapRandevuDto(vtGuncellenmis);
    }

    @Override
    public void randevuSil(Long Id) {
        randevuRepository.findById(Id).orElseThrow(() -> new KaynakBulunamadiException("Bu id ile kayıtlı personel bulunamadı."));
        randevuRepository.deleteById(Id);
    }




}
