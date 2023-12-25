package com.uludag.kuafor.controller;

import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.service.KuaforService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
        KuaforDto kuaforDto = kuaforService.saatGoruntule(kuaforId,guncelSaat);
        return ResponseEntity.ok(kuaforDto);
    }
}