package com.uludag.kuafor.service.impl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.KuaforMapper;
import com.uludag.kuafor.repository.KuaforRepository;
import com.uludag.kuafor.service.KuaforService;
import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service

public class KuaforImpl implements KuaforService {

    private final KuaforRepository kuaforRepository;
    
    @Override
    public KuaforDto saatGoruntule(Long id) {
        Kuafor kuafor = kuaforRepository.findById(id)
                .orElseThrow(() -> new KaynakBulunamadiException("Kayıtlı mesai bulunamadı."));
        return KuaforMapper.mapToKuaforDto(kuafor);
    }

    @Override
    @JsonIgnoreProperties({"id, kullanici_adi,sifre,ad,soyad"})
    public KuaforDto saatGuncelle(Long kuaforId, KuaforDto guncelSaat) 
    {
        Kuafor kuaforSaat = kuaforRepository.findById(kuaforId).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));

        kuaforSaat.setBaslangic_saati(guncelSaat.getBaslangic_saati());
        kuaforSaat.setBitis_saati(guncelSaat.getBitis_saati());
       

        Kuafor vtGuncellenmis = kuaforRepository.save(kuaforSaat);
        return KuaforMapper.mapToKuaforDto(vtGuncellenmis);
    }

    /* 
    @Override
    public List<LocalTime> generateCalismaSaatleri(LocalTime baslamaSaati, LocalTime cikmaSaati) {
        List<LocalTime> calismaSaatleri = new ArrayList<>();

        while (baslamaSaati.isBefore(cikmaSaati)) {
            calismaSaatleri.add(baslamaSaati);
            baslamaSaati = baslamaSaati.plusHours(1);
        }

        return calismaSaatleri;
    }
    */

    @Override
    public List<LocalTime> calismaSaatleri(Long kuaforId, LocalTime baslamaSaati, LocalTime bitisSaati) {
        KuaforDto kuafor = saatGoruntule(kuaforId); 
        baslamaSaati = kuafor.getBaslangic_saati();
        bitisSaati = kuafor.getBitis_saati();
        List<LocalTime> calismaSaatleri = new ArrayList<>();
        while (baslamaSaati.isBefore(bitisSaati)) {
            calismaSaatleri.add(baslamaSaati);
            baslamaSaati = baslamaSaati.plusHours(1);
        }
        return calismaSaatleri;
        }
    }


