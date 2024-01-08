package com.uludag.kuafor.controller;

import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.entity.Randevu;
import com.uludag.kuafor.service.RandevuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.uludag.kuafor.dto.MusteriDto;
import com.uludag.kuafor.service.MusteriService;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/musteri")
@CrossOrigin

public class MusteriController {
    MusteriService musteriService;

    //Musteri ekleme -> üyelik işleminde kullanılabilir
    @PostMapping
    public ResponseEntity<MusteriDto> musteriEkle(@RequestBody MusteriDto musteriDto){
        MusteriDto kaydedilmisMusteri = musteriService.musteriEkle(musteriDto);
        return new ResponseEntity<>(kaydedilmisMusteri, HttpStatus.CREATED);
    }

    //Musterilerin hepsini getir
    @GetMapping
    public ResponseEntity<List<MusteriDto>>musteriGoster() {
        List<MusteriDto> musteriDtoList = musteriService.musteriGoster();
        return ResponseEntity.ok(musteriDtoList);
    }


    //Musteri getir
    @GetMapping("{id}")
    public ResponseEntity<MusteriDto> idIleGetir(@PathVariable("id") Long Id) {
        MusteriDto musteriDto = musteriService.idIleGetir(Id);
        return ResponseEntity.ok(musteriDto);
    }

    //Musteri güncelleme
    @PutMapping("{id}")
    public ResponseEntity<MusteriDto>musteriGuncelle(@PathVariable Long id,@RequestBody MusteriDto guncelMusteri){
        MusteriDto musteriDto = musteriService.musteriGuncelle(id,guncelMusteri);
        return ResponseEntity.ok(musteriDto);
    }

    //Musteri silme
    @DeleteMapping("{id}")
    public ResponseEntity<String>MusteriSil(@PathVariable("id") Long Id) {
        musteriService.musteriSil(Id);
        return ResponseEntity.ok("Hesap Silindi!");
    }

    @GetMapping("/randevular/{id}")
    public List<Randevu> getRandevularByMusteriId(@PathVariable("id") Long musteriId) {
        return musteriService.getMusteriRandevular(musteriId);
    }
}
