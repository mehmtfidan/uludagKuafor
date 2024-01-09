package com.uludag.kuafor.service.impl;
import com.uludag.kuafor.dto.AdminDto;
import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.entity.Admin;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.AdminMapper;
import com.uludag.kuafor.mapper.KuaforMapper;
import com.uludag.kuafor.repository.AdminRepository;
import com.uludag.kuafor.repository.KuaforRepository;
import com.uludag.kuafor.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminImpl implements AdminService {
    KuaforRepository kuaforRepository;
    AdminRepository adminRepository;

    @Override
    public KuaforDto kuaforEkle(KuaforDto kuaforDto) {
        Kuafor kuafor = KuaforMapper.mapToKuafor(kuaforDto);
        Kuafor kaydedilmisKuafor = kuaforRepository.save(kuafor);
        return KuaforMapper.mapToKuaforDto(kaydedilmisKuafor);
    }

    @Override
    public KuaforDto idIleGoster(Long id) {
        Kuafor kuafor = kuaforRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));
        return KuaforMapper.mapToKuaforDto(kuafor);
    }

    @Override
    public List<KuaforDto> kuaforGoster() {
        List<Kuafor> kuaforler = kuaforRepository.findAll();
        return kuaforler.stream().map(kuafor -> KuaforMapper.mapToKuaforDto(kuafor)).collect(Collectors.toList());
    }

    @Override
    public KuaforDto kuaforGuncelle(Long id, KuaforDto guncellenenKuafor) {
        Kuafor kuafor = kuaforRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));

        kuafor.setAd(guncellenenKuafor.getAd());
        kuafor.setSoyad(guncellenenKuafor.getSoyad());
        kuafor.setSifre(guncellenenKuafor.getSifre());
        kuafor.setKullanici_adi(guncellenenKuafor.getKullanici_adi());
        kuafor.setBaslangic_saati(guncellenenKuafor.getBaslangic_saati());
        kuafor.setBitis_saati(guncellenenKuafor.getBitis_saati());

        Kuafor vtGuncellenmis = kuaforRepository.save(kuafor);
        return KuaforMapper.mapToKuaforDto(vtGuncellenmis);
    }

    @Override
    public void kuaforSil(Long id) {
        kuaforRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu id ile kayıtlı personel bulunamadı."));
        kuaforRepository.deleteById(id);
    }

    @Override
    public AdminDto adminEkle(AdminDto adminDto) {
        Admin admin = AdminMapper.mapToAdmin(adminDto);
        Admin kaydedilmisAdmin = adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(kaydedilmisAdmin);
    }

    @Override
    public List<AdminDto> adminGoster() {
        List<Admin> adminler = adminRepository.findAll();
        return adminler.stream().map(admin -> AdminMapper.mapToAdminDto(admin)).collect(Collectors.toList());
    }

    @Override
    public AdminDto adminGuncelle(Long id, AdminDto guncellenenAdmin) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));
        admin.setKullanici_adi(admin.getKullanici_adi());
        admin.setSifre(admin.getSifre());
        admin.setRol(admin.getRol());

        Admin vtGuncellenmisAdmin = adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(vtGuncellenmisAdmin);
    }

    @Override
    public void adminSil(Long id) {
        adminRepository.findById(id).orElseThrow(()-> new KaynakBulunamadiException("Bu id ile kayitli admin bulunamadi"));
        adminRepository.deleteById(id);
    }

}
