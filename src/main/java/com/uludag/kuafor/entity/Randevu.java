package com.uludag.kuafor.entity;

import java.time.LocalTime;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnore
    private Long id;
    @ManyToOne
    @JoinColumn(name = "musteri_id")
    private Musteri musteri;
    @ManyToOne
    @JoinColumn(name = "kuafor_id")
    private Kuafor kuafor;
    private String musteriNotu;
    private LocalTime randevuSaati;
    private Date randevuGunu;
}
