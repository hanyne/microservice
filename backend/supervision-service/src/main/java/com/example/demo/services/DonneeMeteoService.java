package com.example.demo.services;

import com.example.demo.entities.DonneeMeteo;
import com.example.demo.repositories.DonneeMeteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonneeMeteoService {

    @Autowired
    private DonneeMeteoRepository donneeMeteoRepository;

    public List<DonneeMeteo> getAllDonneesMeteo() {
        return donneeMeteoRepository.findAll();
    }

    public Optional<DonneeMeteo> getDonneeMeteoById(Long id) {
        return donneeMeteoRepository.findById(id);
    }

    public List<DonneeMeteo> getDonneesMeteoByParcelleId(Long parcelleId) {
        return donneeMeteoRepository.findByParcelleId(parcelleId);
    }

    public DonneeMeteo saveDonneeMeteo(DonneeMeteo donneeMeteo) {
        return donneeMeteoRepository.save(donneeMeteo);
    }

    public void deleteDonneeMeteo(Long id) {
        donneeMeteoRepository.deleteById(id);
    }
}