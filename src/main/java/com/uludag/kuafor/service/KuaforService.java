package com.uludag.kuafor.service;

import java.time.LocalTime;
import java.util.List;

import com.uludag.kuafor.dto.KuaforDto;


public interface KuaforService {
    KuaforDto saatGoruntule(Long id);

    KuaforDto saatGuncelle(Long kuaforId, KuaforDto guncelSaat);    

    List<LocalTime> generateCalismaSaatleri(LocalTime baslamaSaati, LocalTime cikmaSaati);
}
