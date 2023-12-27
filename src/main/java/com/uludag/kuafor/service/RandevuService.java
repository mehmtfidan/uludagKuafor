package com.uludag.kuafor.service;

import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;

import java.util.List;

public interface RandevuService {
        List<RandevuDto> randevuGoster();
        Randevu randevuKaydet(Randevu kaydedilenRandevu);

        RandevuDto idIleRandevuGoster(Long id);
}
