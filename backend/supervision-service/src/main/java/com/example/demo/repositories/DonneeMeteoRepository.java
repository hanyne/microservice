package com.example.demo.repositories;

import com.example.demo.entities.DonneeMeteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonneeMeteoRepository extends JpaRepository<DonneeMeteo, Long> {
    List<DonneeMeteo> findByParcelleId(Long parcelleId);
}