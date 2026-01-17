package com.example.demo.repositories;

import com.example.demo.entities.DonneeCapteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonneeCapteurRepository extends JpaRepository<DonneeCapteur, Long> {
    List<DonneeCapteur> findByParcelleId(Long parcelleId);
}