package com.uludag.kuafor.controller;
import com.uludag.kuafor.dto.KuaforDto;
import com.uludag.kuafor.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/kuaforler")

public class AdminController {
    private AdminService adminService;
    //Kuafor ekleme
    @PostMapping
    public ResponseEntity<KuaforDto> kuaforEkle(@RequestBody KuaforDto kuaforDto){
        KuaforDto kaydedilmisKuafor = adminService.kuaforEkle(kuaforDto);
        return new ResponseEntity<>(kaydedilmisKuafor, HttpStatus.CREATED);
    }
    //Kuaforlerin hepsini getir
    @GetMapping
    public ResponseEntity<List<KuaforDto>>kuaforGoster() {
        List<KuaforDto> kuaforDtoList = adminService.kuaforGoster();
        return ResponseEntity.ok(kuaforDtoList);
    }
    //Kuafor getir
    @GetMapping("{id}")
    public ResponseEntity<KuaforDto> idIleGetir(@PathVariable("id") Long Id) {
        KuaforDto kuaforDto = adminService.idIleGoster(Id);
        return ResponseEntity.ok(kuaforDto);
    }
    //Kuafor güncelleme
    @PutMapping("{id}")
    public ResponseEntity<KuaforDto>kuaforGuncelle(@PathVariable("id") Long personelId, @RequestBody KuaforDto guncelKuafor){
        KuaforDto kuaforDto = adminService.kuaforGuncelle(personelId,guncelKuafor);
        return ResponseEntity.ok(kuaforDto);
    }
    //Kuafor silme
    @DeleteMapping("{id}")
    public ResponseEntity<String>kuaforSil(@PathVariable("id") Long Id){
        adminService.kuaforSil(Id);
        return ResponseEntity.ok("Kuaför başarıyla silindi.");
    }
}
