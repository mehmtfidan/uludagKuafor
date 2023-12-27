package com.uludag.kuafor.service.impl;
import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.exception.KaynakBulunamadiException;
import com.uludag.kuafor.mapper.AdminMapper;
import com.uludag.kuafor.repository.AdminRepository;
import com.uludag.kuafor.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminImpl implements AdminService {
    AdminRepository adminRepository;

    @Override
    public KuaforDto kuaforEkle(KuaforDto kuaforDto) {
        Kuafor kuafor = AdminMapper.mapToKuafor(kuaforDto);
        Kuafor kaydedilmisKuafor = adminRepository.save(kuafor);
        return AdminMapper.mapToKuaforDto(kaydedilmisKuafor);
    }

    @Override
    public KuaforDto idIleGoster(Long id) {
        Kuafor kuafor = adminRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));
        return AdminMapper.mapToKuaforDto(kuafor);
    }

    @Override
    public List<KuaforDto> kuaforGoster() {
        List<Kuafor> kuaforler = adminRepository.findAll();
        return kuaforler.stream().map(kuafor -> AdminMapper.mapToKuaforDto(kuafor)).collect(Collectors.toList());
    }

    @Override
    public KuaforDto kuaforGuncelle(Long id, KuaforDto guncellenenKuafor) {
        Kuafor kuafor = adminRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu ID ile kayıtlı kuaför bulunmamaktadır."));

        kuafor.setAd(guncellenenKuafor.getAd());
        kuafor.setSoyad(guncellenenKuafor.getSoyad());
        kuafor.setSifre(guncellenenKuafor.getSifre());
        kuafor.setKullanici_adi(guncellenenKuafor.getKullanici_adi());
        kuafor.setBaslangic_saati(guncellenenKuafor.getBaslangic_saati());
        kuafor.setBitis_saati(guncellenenKuafor.getBitis_saati());

        Kuafor vtGuncellenmis = adminRepository.save(kuafor);
        return AdminMapper.mapToKuaforDto(vtGuncellenmis);
    }

    @Override
    public void kuaforSil(Long id) {
        adminRepository.findById(id).orElseThrow(() -> new KaynakBulunamadiException("Bu id ile kayıtlı personel bulunamadı."));
        adminRepository.deleteById(id);
    }

}
