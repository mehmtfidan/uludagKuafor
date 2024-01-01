package com.uludag.kuafor.controller;

import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.service.KuaforService;
import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/kuafor")
@CrossOrigin
public class KuaforController {
    KuaforService kuaforService;

    @GetMapping("{id}")
    public ResponseEntity<KuaforDto>saatGoruntule(@PathVariable ("id") Long id){
        KuaforDto kuaforDto = kuaforService.saatGoruntule(id);
        return ResponseEntity.ok(kuaforDto);
        
    }
    @PutMapping("{id}")
    public ResponseEntity<KuaforDto>saatGuncelle(@PathVariable("id") Long kuaforId, @RequestBody KuaforDto guncelSaat){
        KuaforDto kuaforDto = kuaforService.saatGuncelle(kuaforId,guncelSaat);
        return ResponseEntity.ok(kuaforDto);
    }
    @GetMapping("/mesai/{id}")
    public List<LocalTime> calismaSaatleri(@PathVariable("id") Long kuaforId,
                                                 @RequestBody KuaforDto kuaforDto ) {

        // KuaforDto kuafor = kuaforService.saatGoruntule(kuaforId); 
        // baslamaSaati = kuafor.getBaslangicSaati();
        // bitisSaati = kuafor.getBitisSaati();
        // List<LocalTime> calismaSaatleri = new ArrayList<>();
        // while (baslamaSaati.isBefore(bitisSaati)) {
        //     calismaSaatleri.add(baslamaSaati);
        //     baslamaSaati = baslamaSaati.plusHours(1);
        // }
        // return calismaSaatleri;
        return this.kuaforService.calismaSaatleri(kuaforId, kuaforDto.getBaslangic_saati(), kuaforDto.getBitis_saati());
        }
    }
        /* 
        while (baslamaSaati.isBefore(bitisSaati)) {
            calismaSaatleri.add(baslamaSaati);
            baslamaSaati = baslamaSaati.plusHours(1);
        }
        */

    ///////
//servise aldım


        