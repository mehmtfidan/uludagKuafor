
package com.uludag.kuafor.repository;
import com.uludag.kuafor.entity.Kuafor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Kuafor, Long> {

}