package com.uludag.kuafor.service;

import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RandevuService {
        List<RandevuDto> randevuGoster();
        Randevu randevuKaydet(Randevu kaydedilenRandevu);
        RandevuDto idIleRandevuGoster(Long id);
        RandevuDto randevuGuncelle(RandevuDto guncelRandevu);
        void randevuSil(Long id);

        public String getRandevuDurumu(Long id);
}
