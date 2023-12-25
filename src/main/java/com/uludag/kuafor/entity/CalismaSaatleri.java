package com.uludag.kuafor.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

@Getter
@Setter
@Entity
public class CalismaSaatleri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kuafor_id")
    private Kuafor kuafor_id;

    @ElementCollection
    @CollectionTable(name = "calisma_saatleri_gunleri", joinColumns = @JoinColumn(name = "calisma_saatleri_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "gun")
    @Column(name = "saat_araligi_baslangic")
    private Map<DayOfWeek, LocalTime[]> calismaSaatleri;

}
