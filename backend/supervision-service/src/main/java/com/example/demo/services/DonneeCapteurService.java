package com.example.demo.services;

import com.example.demo.entities.DonneeCapteur;
import com.example.demo.repositories.DonneeCapteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonneeCapteurService {

    @Autowired
    private DonneeCapteurRepository donneeCapteurRepository;

    public List<DonneeCapteur> getAllDonneesCapteur() {
        return donneeCapteurRepository.findAll();
    }

    public Optional<DonneeCapteur> getDonneeCapteurById(Long id) {
        return donneeCapteurRepository.findById(id);
    }

    public List<DonneeCapteur> getDonneesCapteurByParcelleId(Long parcelleId) {
        return donneeCapteurRepository.findByParcelleId(parcelleId);
    }

    public DonneeCapteur saveDonneeCapteur(DonneeCapteur donneeCapteur) {
        return donneeCapteurRepository.save(donneeCapteur);
    }

    public void deleteDonneeCapteur(Long id) {
        donneeCapteurRepository.deleteById(id);
    }
}