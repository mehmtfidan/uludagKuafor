package com.uludag.kuafor.service;

import java.time.LocalTime;
import java.util.List;


import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;


public interface KuaforService {
    KuaforDto bilgiGoruntule(Long id);
    KuaforDto bilgiGuncelle(Long kuaforId, KuaforDto guncelSaat);
    List<LocalTime> calismaSaatleri(Long kuaforId, LocalTime baslamaSaati,LocalTime bitisSaati);
    List<Randevu> getKuaforRandevular(Long id);
    RandevuDto setRandevuDurumu(Long id, RandevuDto rDurum);
}
