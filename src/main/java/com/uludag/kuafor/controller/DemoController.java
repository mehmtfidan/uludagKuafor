package com.uludag.kuafor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo-controller")

public class DemoController {
//    @GetMapping
//    public ResponseEntity<String> sayHello() {
//        return ResponseEntity.ok("Hello from secured endpoint");
//    }


    @GetMapping("/musteri")
    public String müsteriDashboard() {
        return "Musteri Dashboard";
    }

//    @GetMapping("/admin-dashboard")
//    public String adminDashboard() {
//        return "Admin Dashboard";
//    }
//
//    @GetMapping("/kuafor-dashboard")
//    public String kuaforDashboard() {
//        return "Admin Dashboard";
//    }

}
