package com.example.demo.controllers;

import com.example.demo.entities.DonneeMeteo;
import com.example.demo.services.DonneeMeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donnees-meteo")
public class DonneeMeteoController {

    @Autowired
    private DonneeMeteoService donneeMeteoService;

    @GetMapping
    public List<DonneeMeteo> getAllDonneesMeteo() {
        return donneeMeteoService.getAllDonneesMeteo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonneeMeteo> getDonneeMeteoById(@PathVariable Long id) {
        Optional<DonneeMeteo> donnee = donneeMeteoService.getDonneeMeteoById(id);
        return donnee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/parcelle/{parcelleId}")
    public List<DonneeMeteo> getDonneesMeteoByParcelleId(@PathVariable Long parcelleId) {
        return donneeMeteoService.getDonneesMeteoByParcelleId(parcelleId);
    }

    @PostMapping
    public DonneeMeteo createDonneeMeteo(@RequestBody DonneeMeteo donneeMeteo) {
        return donneeMeteoService.saveDonneeMeteo(donneeMeteo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonneeMeteo> updateDonneeMeteo(@PathVariable Long id, @RequestBody DonneeMeteo details) {
        Optional<DonneeMeteo> optional = donneeMeteoService.getDonneeMeteoById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        DonneeMeteo donnee = optional.get();
        donnee.setParcelleId(details.getParcelleId());
        donnee.setTemperature(details.getTemperature());
        donnee.setHumiditeAir(details.getHumiditeAir());
        donnee.setPluviometrie(details.getPluviometrie());
        donnee.setDate(details.getDate());
        DonneeMeteo updated = donneeMeteoService.saveDonneeMeteo(donnee);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonneeMeteo(@PathVariable Long id) {
        donneeMeteoService.deleteDonneeMeteo(id);
        return ResponseEntity.noContent().build();
    }
}