package com.uludag.kuafor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Hizmet")
public class Hizmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hizmet;
    private String ucret;
    @ManyToOne
    @JoinColumn(name = "hizmet_kuafor_id")
    private HizmetKuafor hizmetKuafor;
}
