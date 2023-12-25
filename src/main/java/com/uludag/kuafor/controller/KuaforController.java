package com.uludag.kuafor.controller;

import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.service.KuaforService;
import lombok.AllArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/kuafor")

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
    public List<LocalTime> getCalismaSaatleri(@PathVariable Long kuaforId,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime baslamaSaati,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime cikmaSaati) {
                                                baslamaSaati = LocalTime.of(12,0);
                                                cikmaSaati= LocalTime.of(20,0);
                                               
                                                return kuaforService.generateCalismaSaatleri(baslamaSaati, cikmaSaati);

    }

}