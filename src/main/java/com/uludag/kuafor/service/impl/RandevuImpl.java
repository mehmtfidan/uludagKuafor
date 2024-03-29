package com.uludag.kuafor.service.impl;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.RandevuMapper;
import com.uludag.kuafor.repository.KuaforRepository;
import com.uludag.kuafor.repository.MusteriRepository;
import com.uludag.kuafor.service.KuaforService;
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
    public List<RandevuDto> randevuGoster(Long randevuId) {
        List<Randevu> randevular = randevuRepository.findAll();
        return randevular.stream().map(randevu -> RandevuMapper.mapRandevuDto(randevu)).collect(Collectors.toList());
    }

//    @Override
//    @JsonIgnoreProperties({"randevuDurumu"})
//    public Randevu randevuKaydet(Randevu randevu) {
//        Randevu vtEklendi = randevuRepository.save(randevu);
//        if (randevu.getRandevuDurumu() == null || randevu.getRandevuDurumu().toLowerCase() != "onaylandı" || randevu.getRandevuDurumu().toLowerCase() != "reddedildi") {
//            randevu.setRandevuDurumu("Beklemede");
//        }
//        return vtEklendi;
//    }

    @Override
    public RandevuDto idIleRandevuGoster(Long Id) {
        Randevu randevu = randevuRepository.findById(Id).orElseThrow(() -> new KaynakBulunamadiException("Kayıtlı randevu bulunamadı."));
        return RandevuMapper.mapRandevuDto(randevu);
    }


    @Override
    public RandevuDto randevuGuncelle(Long id, RandevuDto guncelRandevu) {
        Randevu randevu = randevuRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı randevu bulunmamaktadır."));
        Musteri musteri = musteriRepository.findById(guncelRandevu.getMusteriId()).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı musteri bulunmamaktadır."));
        Kuafor kuafor = kuaforRepository.findById(guncelRandevu.getKuaforId()).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));

        randevu.setId(randevu.getId());
        randevu.getMusteri().setId(randevu.getMusteri().getId());
        randevu.getKuafor().setId(randevu.getKuafor().getId());
        randevu.setMusteriNotu(guncelRandevu.getMusteriNotu());
        randevu.setRandevuSaati(guncelRandevu.getRandevuSaati());
        randevu.setRandevuGunu(guncelRandevu.getRandevuGunu());
        randevu.setHizmetler(guncelRandevu.getHizmetler());
        randevu.setRandevuDurumu(Character.toUpperCase(guncelRandevu.getRandevuDurumu().charAt(0)) + guncelRandevu.getRandevuDurumu().substring(1));

        Randevu vtGuncellenmis = randevuRepository.save(randevu);
        return RandevuMapper.mapRandevuDto(vtGuncellenmis);
    }

    @Override
    public void randevuSil(Long Id) {
        randevuRepository.findById(Id).orElseThrow(() -> new KaynakBulunamadiException("Bu id ile randevu bulunamadı."));
        randevuRepository.deleteById(Id);
    }

    @Override
    public RandevuDto randevuEkle(RandevuDto randevuDto) {
        Musteri musteri = musteriRepository.findById(randevuDto.getMusteriId()).orElseThrow(() -> new KaynakBulunamadiException("Kayıtlı müşteri bulunamadı."));
        Kuafor kuafor = kuaforRepository.findById(randevuDto.getKuaforId()).orElseThrow(() -> new KaynakBulunamadiException("Kayıtlı müşteri bulunamadı."));

        Randevu randevu = RandevuMapper.maptoRandevu(randevuDto);
        randevu.setMusteri(musteri);
        randevu.setKuafor(kuafor);

        if (randevu.getRandevuDurumu() == null || randevu.getRandevuDurumu().toLowerCase() != "onaylandı" || randevu.getRandevuDurumu().toLowerCase() != "reddedildi") {
            randevu.setRandevuDurumu("Beklemede");
        }
        Randevu eklenenRandevu = randevuRepository.save(randevu);
        return RandevuMapper.mapRandevuDto(eklenenRandevu);
    }
}
