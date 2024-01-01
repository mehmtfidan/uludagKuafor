package com.uludag.kuafor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HizmetKuafor")
public class HizmetKuafor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "kuafor_id")
    private Kuafor kuafor;
    @ManyToOne
    @JoinColumn(name = "hizmet_id")
    private Hizmet hizmet;
}
