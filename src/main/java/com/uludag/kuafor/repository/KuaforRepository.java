package com.uludag.kuafor.repository;

import com.uludag.kuafor.entity.Kuafor;
import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface KuaforRepository extends JpaRepository <Kuafor,Long> {
    @Query("SELECT r FROM Randevu r JOIN FETCH r.kuafor k WHERE k.id = :kuafor_id")
    List<Randevu> findKuaforById(Long kuafor_id);

    @Query("SELECT m FROM Kuafor m WHERE m.id = :id")
    Optional<Musteri> findKuaforBy(Long id);
}
