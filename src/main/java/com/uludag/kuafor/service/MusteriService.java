package com.uludag.kuafor.service;
import com.uludag.kuafor.dto.MusteriDto;
import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.entity.Randevu;

import java.util.List;
public interface MusteriService {
   MusteriDto musteriEkle(MusteriDto musteriDto);
    MusteriDto idIleGetir(Long id);
   List<MusteriDto> musteriGoster();
    MusteriDto musteriGuncelle(Long id,MusteriDto guncellenenMusteri);
    void musteriSil(Long Id);

    public List<Randevu> getMusteriRandevular(Long id);
//    Musteri randevuKaydet(Musteri musteri);
//
//    RandevuDto idIleRandevuGoster(Long id);
}
