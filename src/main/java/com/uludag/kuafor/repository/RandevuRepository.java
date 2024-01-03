
package com.uludag.kuafor.repository;
import com.uludag.kuafor.entity.Randevu;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;


public interface RandevuRepository extends JpaRepository<Randevu, Long>  {

}