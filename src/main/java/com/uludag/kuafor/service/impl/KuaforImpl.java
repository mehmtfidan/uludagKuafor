package com.uludag.kuafor.service.impl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.KuaforMapper;
import com.uludag.kuafor.repository.KuaforRepository;
import com.uludag.kuafor.service.KuaforService;
import lombok.AllArgsConstructor;

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
    public KuaforDto saatGoruntule(Long kuaforId, KuaforDto guncelSaat) 
    {
        Kuafor kuaforSaat = kuaforRepository.findById(kuaforId).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));

        kuaforSaat.setBaslangicSaati(guncelSaat.getBaslangicSaati());
        kuaforSaat.setBitisSaati(guncelSaat.getBitisSaati());
       

        Kuafor vtGuncellenmis = kuaforRepository.save(kuaforSaat);
        return KuaforMapper.mapToKuaforDto(vtGuncellenmis);
    }
 }

