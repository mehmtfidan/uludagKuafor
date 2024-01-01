package com.uludag.kuafor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Kuafor")
public class Kuafor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kullanici_adi;
    private String sifre;
    private String ad;
    private String soyad;
    @ManyToOne
    @JoinColumn(name = "hizmet_kuafor_id")
    private HizmetKuafor hizmetKuafor;
    @OneToMany(mappedBy = "kuafor", cascade = CascadeType.ALL)
    private List<Randevu> randevular;
    private LocalTime baslangic_saati;
    private LocalTime bitis_saati;
}
