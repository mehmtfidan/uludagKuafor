package com.uludag.kuafor.entity;

import java.time.LocalTime;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Randevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private Long musteriId;
    @ManyToOne
    @JoinColumn(name = "kuafor_id")
    private Kuafor kuafor_id;
    private String islemler;
    private String musteriNotu;
    private LocalTime randevuSaati;
    private Date randevuGunu;
}
