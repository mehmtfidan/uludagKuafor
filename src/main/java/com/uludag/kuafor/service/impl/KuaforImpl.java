package com.uludag.kuafor.service.impl;
import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.entity.Randevu;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.KuaforMapper;
import com.uludag.kuafor.mapper.RandevuMapper;
import com.uludag.kuafor.repository.KuaforRepository;
import com.uludag.kuafor.repository.RandevuRepository;
import com.uludag.kuafor.service.KuaforService;
import com.uludag.kuafor.service.RandevuService;
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
    public KuaforDto bilgiGoruntule(Long id) {
        Kuafor kuafor = kuaforRepository.findById(id)
                .orElseThrow(() -> new KaynakBulunamadiException("Kayıtlı mesai bulunamadı."));
        return KuaforMapper.mapToKuaforDto(kuafor);
    }

    @Override
    public KuaforDto bilgiGuncelle(Long kuaforId, KuaforDto guncelBilgi)
    {
        Kuafor kuaforSaat = kuaforRepository.findById(kuaforId).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));

        kuaforSaat.setBaslangic_saati(guncelBilgi.getBaslangic_saati());
        kuaforSaat.setBitis_saati(guncelBilgi.getBitis_saati());

        Kuafor vtGuncellenmis = kuaforRepository.save(kuaforSaat);
        return KuaforMapper.mapToKuaforDto(vtGuncellenmis);
    }
    public List<Randevu> getKuaforRandevular(Long id) {
        return kuaforRepository.findKuaforById(id);
    }

    @Override
    public List<LocalTime> calismaSaatleri(Long kuaforId, LocalTime baslamaSaati, LocalTime bitisSaati) {
        KuaforDto kuafor = bilgiGoruntule(kuaforId);
        baslamaSaati = kuafor.getBaslangic_saati();
        bitisSaati = kuafor.getBitis_saati();
        List<LocalTime> calismaSaatleri = new ArrayList<>();
        while (baslamaSaati.isBefore(bitisSaati)) {
            calismaSaatleri.add(baslamaSaati);
            baslamaSaati = baslamaSaati.plusHours(1);
        }
        return calismaSaatleri;
        }
        RandevuService randevuService;
    RandevuRepository randevuRepository;
    @Override
    public RandevuDto setRandevuDurumu(Long id, RandevuDto rDurum) {
        Randevu randevuDurum = randevuRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("randevu bulunamadı"));

        if (rDurum.getRandevuDurumu().equals("")) {
             randevuDurum.setRandevuDurumu("Beklemede");
        } else if (rDurum.getRandevuDurumu().toLowerCase().equals("onaylandı")||
                rDurum.getRandevuDurumu().toLowerCase().equals("reddedildi")) {
            randevuDurum.setRandevuDurumu(Character.toUpperCase(rDurum.getRandevuDurumu().charAt(0)) + rDurum.getRandevuDurumu().substring(1));
        }
        else{
            randevuDurum.setRandevuDurumu("Beklemede");
        }
        Randevu vtGuncellenmis = randevuRepository.save(randevuDurum);
        return RandevuMapper.mapRandevuDto(vtGuncellenmis);
    }
}



