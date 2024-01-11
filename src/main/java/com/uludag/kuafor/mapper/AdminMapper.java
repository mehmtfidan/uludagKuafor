package com.uludag.kuafor.mapper;

import com.uludag.kuafor.dto.AdminDto;
import com.uludag.kuafor.entity.Admin;

public class AdminMapper {
    public static AdminDto mapToAdminDto(Admin admin){
        return new AdminDto(
                admin.getId(),admin.getKullanici_adi(),admin.getSifre(),admin.getRol(),admin.getRol().getId()
        );
    }
    public static Admin mapToAdmin(AdminDto adminDto){
        return new Admin(
                adminDto.getId(),adminDto.getKullanici_adi(),adminDto.getSifre(),adminDto.getRol()
        );
    }
}
