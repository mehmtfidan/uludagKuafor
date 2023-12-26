package com.uludag.kuafor.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.uludag.kuafor.dto.MusteriDto;
import com.uludag.kuafor.service.MusteriService;

import lombok.AllArgsConstructor;




@AllArgsConstructor
@RestController
@RequestMapping("/api/musteri")
@CrossOrigin

public class MusteriController {
    private MusteriService musteriService;

    //Musteri ekleme
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
    public ResponseEntity<MusteriDto>musteriGuncelle(@PathVariable("id") Long Id, @RequestBody MusteriDto guncelMusteri){
        MusteriDto musteriDto = musteriService.musteriGuncelle(Id,guncelMusteri);
        return ResponseEntity.ok(musteriDto);
    }




    //Musteri silme
    @DeleteMapping("{id}")
    public ResponseEntity<String>MusteriSil(@PathVariable("id") Long Id){
        musteriService.musteriSil(Id);
        return ResponseEntity.ok("Kuaför başariyla silindi.");
    }


}
