package com.uludag.kuafor.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;


public interface KuaforService {
    KuaforDto bilgiGoruntule(Long id);
    KuaforDto bilgiGuncelle(Long kuaforId, KuaforDto guncelSaat);
    List<LocalTime> calismaSaatleri(Long kuaforId);
    List<Randevu> getKuaforRandevular(Long id);
    RandevuDto setRandevuDurumu(Long id, RandevuDto rDurum);
    RandevuDto getRandevuDurumu(Long randevuId);

}
