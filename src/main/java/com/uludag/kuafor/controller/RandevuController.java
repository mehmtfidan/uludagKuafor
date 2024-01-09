package com.uludag.kuafor.controller;
import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.dto.RandevuDto;
import com.uludag.kuafor.entity.Randevu;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uludag.kuafor.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/randevu")
@CrossOrigin
public class RandevuController {
    
    RandevuService randevuService;

    //Randevuların hepsini getir
    @GetMapping
    public ResponseEntity<List<RandevuDto>>randevuGoster() {
        List<RandevuDto> randevuDtoList = randevuService.randevuGoster();
        return ResponseEntity.ok(randevuDtoList);
    }
    @PostMapping
    public Randevu randevuKaydet(@RequestBody Randevu randevu) {
        return randevuService.randevuKaydet(randevu);
    }

    @GetMapping("{Id}")
    public ResponseEntity<RandevuDto> idIleRandevuGoster(@PathVariable("Id") Long Id){
        RandevuDto randevuDto = randevuService.idIleRandevuGoster(Id);
        return ResponseEntity.ok(randevuDto);
    }
    @DeleteMapping("{Id}")
    public ResponseEntity<String>randevuSil(@PathVariable("Id") Long Id){
        randevuService.randevuSil(Id);
        return ResponseEntity.ok("Randevu başarıyla silindi.");
    }
    @PutMapping
    public ResponseEntity<RandevuDto>randevuGuncelle(@RequestBody RandevuDto guncelRandevu){
        RandevuDto randevuDto = randevuService.randevuGuncelle(guncelRandevu);
        return ResponseEntity.ok(randevuDto);
    }
    @GetMapping("/durum/{randevuId}")
    public ResponseEntity<String> getRandevuDurumu(@PathVariable("randevuId") Long randevuId) {
        String durum = randevuService.getRandevuDurumu(randevuId);
        return ResponseEntity.ok(durum);
    }
}
