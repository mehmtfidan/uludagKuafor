package com.uludag.kuafor.controller;
import com.uludag.kuafor.dto.RandevuDto;
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
@RequestMapping("/api/randevular")
@CrossOrigin
public class RandevuController {
    
    RandevuService randevuService;

    //Randevuların hepsini getir
    @GetMapping
    public ResponseEntity<List<RandevuDto>>randevuGoster() {
        List<RandevuDto> randevuDtoList = randevuService.randevuGoster();
        return ResponseEntity.ok(randevuDtoList);
    }
}
