package com.uludag.kuafor.dto;

import com.uludag.kuafor.entity.HizmetKuafor;
import jakarta.persistence.*;

public class HizmetDto {
    private Long id;
    private String hizmet;
    private String ucret;
    private HizmetKuafor hizmetKuafor;
}
