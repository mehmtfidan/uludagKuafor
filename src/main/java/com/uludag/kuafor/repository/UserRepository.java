package com.uludag.kuafor.repository;

import com.uludag.kuafor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByKullanici_adi(String kullanici_adi);
}
