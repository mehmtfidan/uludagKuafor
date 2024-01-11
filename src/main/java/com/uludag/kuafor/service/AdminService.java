package com.uludag.kuafor.service;

import com.uludag.kuafor.dto.AdminDto;
import com.uludag.kuafor.dto.KuaforDto;

import java.util.List;

public interface AdminService {
    KuaforDto kuaforEkle(KuaforDto kuaforDto) ;
    KuaforDto idIleGoster(Long id);
    List<KuaforDto> kuaforGoster();
    KuaforDto kuaforGuncelle(Long id, KuaforDto guncellenenKuafor);
    void kuaforSil(Long id);

    AdminDto adminEkle(AdminDto adminDto);
    List<AdminDto> adminGoster();
    AdminDto adminGuncelle(Long id, AdminDto guncellenenAdmin);
    void adminSil(Long id);
}
