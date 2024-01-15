package com.uludag.kuafor.service;

import com.uludag.kuafor.dto.MusteriDto;
import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public interface RandevuService {
        List<RandevuDto> randevuGoster();
        RandevuDto idIleRandevuGoster(Long id);
        RandevuDto randevuGuncelle(RandevuDto guncelRandevu);
        void randevuSil(Long id);

        RandevuDto randevuEkle(RandevuDto randevuDto);
//        List<LocalTime> calismaSaatleri(Long kuaforId, LocalTime baslamaSaati, LocalTime bitisSaati);


}
