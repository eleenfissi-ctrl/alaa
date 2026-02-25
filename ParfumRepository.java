package com.alaa.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alaa.entities.Parfum;   
@Repository
public interface ParfumRepository extends JpaRepository<Parfum, Long> {
   
}
