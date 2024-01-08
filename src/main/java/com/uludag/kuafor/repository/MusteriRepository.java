package com.uludag.kuafor.repository;

import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusteriRepository extends JpaRepository<Musteri,Long> {
    @Query("SELECT r FROM Randevu r JOIN FETCH r.musteri m WHERE m.id = :musteri_id")

//    @Query("select  id,  randevuGunu, randevuSaati, musteriNotu " +
//            "from Randevu " +
//            "where musteri.id = :musteri_id")
    List<Randevu> findMusteriBy(Long musteri_id);
}
