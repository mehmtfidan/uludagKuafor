package com.uludag.kuafor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo-controller")

public class DemoController {
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }


    @GetMapping("/musteri")
    public String müsteriDashboard() {
        return "Musteri Sayfası";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "Admin Sayfası";
    }

    @GetMapping("/kuafor")
    public String kuaforDashboard() {
        return "Admin Sayfası";
    }

}
