package com.example.demo.controllers;

import com.example.demo.entities.DonneeCapteur;
import com.example.demo.services.DonneeCapteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donnees-capteur")
public class DonneeCapteurController {

    @Autowired
    private DonneeCapteurService donneeCapteurService;

    @GetMapping
    public List<DonneeCapteur> getAllDonneesCapteur() {
        return donneeCapteurService.getAllDonneesCapteur();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonneeCapteur> getDonneeCapteurById(@PathVariable Long id) {
        Optional<DonneeCapteur> donnee = donneeCapteurService.getDonneeCapteurById(id);
        return donnee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/parcelle/{parcelleId}")
    public List<DonneeCapteur> getDonneesCapteurByParcelleId(@PathVariable Long parcelleId) {
        return donneeCapteurService.getDonneesCapteurByParcelleId(parcelleId);
    }

    @PostMapping
    public DonneeCapteur createDonneeCapteur(@RequestBody DonneeCapteur donneeCapteur) {
        return donneeCapteurService.saveDonneeCapteur(donneeCapteur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonneeCapteur> updateDonneeCapteur(@PathVariable Long id, @RequestBody DonneeCapteur details) {
        Optional<DonneeCapteur> optional = donneeCapteurService.getDonneeCapteurById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        DonneeCapteur donnee = optional.get();
        donnee.setParcelleId(details.getParcelleId());
        donnee.setType(details.getType());
        donnee.setValeur(details.getValeur());
        donnee.setDate(details.getDate());
        DonneeCapteur updated = donneeCapteurService.saveDonneeCapteur(donnee);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonneeCapteur(@PathVariable Long id) {
        donneeCapteurService.deleteDonneeCapteur(id);
        return ResponseEntity.noContent().build();
    }
}