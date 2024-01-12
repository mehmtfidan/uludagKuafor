package com.uludag.kuafor.repository;

import com.uludag.kuafor.entity.Musteri;
import com.uludag.kuafor.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MusteriRepository extends JpaRepository<Musteri,Long> {
    @Query("SELECT r FROM Randevu r JOIN FETCH r.musteri m WHERE m.id = :musteri_id")
    List<Randevu> findMusteriBy(Long musteri_id);
    @Query("SELECT m FROM Musteri m WHERE m.id = :id")
    Optional<Musteri> findmusteriBy(Long id);
}
