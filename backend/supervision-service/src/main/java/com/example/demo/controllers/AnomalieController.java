package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.AnomalieService;

@RestController
@RequestMapping("/api/anomalies")
public class AnomalieController {

    @Autowired
    private AnomalieService anomalieService;

    @PostMapping("/detect/{parcelleId}")
    public String detectAnomalies(@PathVariable Long parcelleId) {
        if (parcelleId == null || parcelleId <= 0) {
            return "Erreur : ID de parcelle invalide";
        }

        anomalieService.detecterAnomalies(parcelleId);
        return "Détection d'anomalies lancée pour la parcelle ID " + parcelleId;
    }
}