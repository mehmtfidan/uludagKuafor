package com.uludag.kuafor.service;

import java.time.LocalTime;
import java.util.List;


import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.entity.Randevu;


public interface KuaforService {
    KuaforDto saatGoruntule(Long id);

    KuaforDto saatGuncelle(Long kuaforId, KuaforDto guncelSaat);

    // public static List<LocalTime> calismaSaatleri(@PathVariable("id") Long kuaforId,
    //                                              @RequestParam @DateTimeFormat(pattern = "HH:mm")LocalTime baslamaSaati,
    //                                              @RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime bitisSaati) {
    //     KuaforDto kuafor = kuaforService.saatGoruntule(kuaforId); 
    //     baslamaSaati = kuafor.getBaslangicSaati();
    //     bitisSaati = kuafor.getBitisSaati();
    //     List<LocalTime> calismaSaatleri = new ArrayList<>();

    //     while (baslamaSaati.isBefore(bitisSaati)) {
    //         calismaSaatleri.add(baslamaSaati);
    //         baslamaSaati = baslamaSaati.plusHours(1);
    //     }
    // }

    // List<LocalTime> generateCalismaSaatleri(LocalTime baslamaSaati, LocalTime cikmaSaati);  
    public List<LocalTime> calismaSaatleri(Long kuaforId, LocalTime baslamaSaati,LocalTime bitisSaati);
    public List<Randevu> getKuaforRandevular(Long id);

    
}
