package com.uludag.kuafor.service;

import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Kuafor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RandevuService {
        List<RandevuDto> randevuGoster(Long randevuId);
        RandevuDto idIleRandevuGoster(Long id);
        RandevuDto randevuGuncelle(Long id,RandevuDto guncelRandevu);

        void randevuSil(Long id);
        RandevuDto randevuEkle(RandevuDto randevuDto);
//        List<LocalTime> calismaSaatleri(Long kuaforId, LocalTime baslamaSaati, LocalTime bitisSaati);
}
