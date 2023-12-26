package com.uludag.kuafor.service;
import com.uludag.kuafor.dto.MusteriDto;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface MusteriService {
    MusteriDto musteriEkle(MusteriDto musteriDto);
    MusteriDto idIleGetir(Long Id);

    List<MusteriDto> musteriGoster();

    MusteriDto musteriGuncelle(Long Id, MusteriDto guncellenenMusteri);

    void musteriSil(Long Id);
}
