package com.uludag.kuafor.service;

import java.time.DayOfWeek;

import com.uludag.kuafor.dto.KuaforDto;

public interface KuaforService {
    KuaforDto saatGoruntule(Long id);

    KuaforDto saatGoruntule(Long kuaforId, KuaforDto guncelSaat);

}
