package com.uludag.kuafor.service;

import com.uludag.kuafor.dto.KuaforDto;

import java.util.List;

public interface AdminService {
    KuaforDto kuaforEkle(KuaforDto kuaforDto) ;
    KuaforDto idIleGoster(Long id);
    List<KuaforDto> kuaforGoster();
    KuaforDto kuaforGuncelle(Long id, KuaforDto guncellenenKuafor);

    void kuaforSil(Long id);
}
