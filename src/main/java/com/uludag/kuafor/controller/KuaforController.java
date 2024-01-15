package com.uludag.kuafor.controller;

import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;
import com.uludag.kuafor.service.KuaforService;
import com.uludag.kuafor.service.RandevuService;
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
    public ResponseEntity<KuaforDto> bilgiGoruntule(@PathVariable ("id") Long Id){
        KuaforDto kuaforDto = kuaforService.bilgiGoruntule(Id);
        return ResponseEntity.ok(kuaforDto);
        
    }
    @PutMapping("{id}")
    public ResponseEntity<KuaforDto> bilgiGuncelle(@PathVariable("id") Long kuaforId, @RequestBody KuaforDto guncelSaat){
        KuaforDto kuaforDto = kuaforService.bilgiGuncelle(kuaforId,guncelSaat);
        return ResponseEntity.ok(kuaforDto);
    }
    @GetMapping("/mesai/{id}")
    public List<LocalTime> calismaSaatleri(@PathVariable("id") Long kuaforId) {
        return this.kuaforService.calismaSaatleri(kuaforId);
        }
    @GetMapping("/randevular/{id}")
    public List<Randevu> getRandevularByMusteriId(@PathVariable("id") Long kuaforId) {
        return kuaforService.getKuaforRandevular(kuaforId);
    }
    RandevuService randevuService;

    @PutMapping("/durum/{randevuId}")
    public ResponseEntity<RandevuDto> setRandevuDurumu(@PathVariable ("randevuId") Long randevuId,@RequestBody RandevuDto rDurum){
        RandevuDto durum = kuaforService.setRandevuDurumu(randevuId, rDurum);
        return ResponseEntity.ok(durum);
    }
}


        