package com.uludag.kuafor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.RandevuMapper;
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

    @Override
    public List<RandevuDto> randevuGoster() {
        List<Randevu> randevular = (List<Randevu>) randevuRepository.findAll();
        return randevular.stream().map(randevu -> RandevuMapper.mapRandevuDto(randevu)).collect(Collectors.toList());

    }

    @Override
    public Randevu randevuKaydet(Randevu randevu) {
        return randevuRepository.save(randevu);
    }

    @Override
    public RandevuDto idIleRandevuGoster(Long id) {
        Randevu randevu = randevuRepository.findById(id).orElseThrow(()-> new KaynakBulunamadiException("Kayıtlı randevu bulunamadı."));
        return RandevuMapper.mapRandevuDto(randevu);
    }

    @Override
    public RandevuDto randevuGuncelle(Long id, RandevuDto guncelRandevu) {
       Randevu randevu  = randevuRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));

//       randevu.setKuaforHizmetId(randevu.getKuaforHizmetId());
//       randevu.setMusteriId(randevu.getMusteriId());
//       randevu.setKuafor_id(randevu.getKuafor_id());
       randevu.setMusteriNotu(randevu.getMusteriNotu());
       randevu.setRandevuSaati(randevu.getRandevuSaati());
       randevu.setRandevuGunu(randevu.getRandevuGunu());

       Randevu vtGuncellenmis = randevuRepository.save(randevu);
       return RandevuMapper.mapRandevuDto(vtGuncellenmis);
    }

    @Override
    public void randevuSil(Long id) {
        randevuRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu id ile kayıtlı personel bulunamadı."));
        randevuRepository.deleteById(id);
    }
}
