package com.example.demo.services;

import com.example.demo.clients.ExploitationClient;
import com.example.demo.dto.ParcelleDTO;
import com.example.demo.entities.DonneeCapteur;
import com.example.demo.messaging.AlerteSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalieService {

    @Autowired
    private DonneeCapteurService capteurService;

    @Autowired
    private ExploitationClient exploitationClient;

    @Autowired
    private AlerteSender alerteSender;

    public void detecterAnomalies(Long parcelleId) {
        List<DonneeCapteur> donnees = capteurService.getDonneesCapteurByParcelleId(parcelleId);

        // On récupère les parcelles de l'exploitation 1 (à améliorer plus tard)
        List<ParcelleDTO> parcelles = exploitationClient.getParcellesByExploitationId(1L);

        // On cherche la parcelle correspondante pour enrichir l'alerte
        ParcelleDTO parcelleInfo = parcelles.stream()
            .filter(p -> p.getId().equals(parcelleId))
            .findFirst()
            .orElse(null);

        String nomParcelle = (parcelleInfo != null) ? parcelleInfo.getCulture() + " (" + parcelleInfo.getEtat() + ")" : "Inconnue";

        for (DonneeCapteur d : donnees) {
            if (d.getValeur() != null && d.getValeur() > 100) {
                String message = String.format(
                    "ANOMALIE CRITIQUE - Parcelle: %s (ID: %d) | Type: %s | Valeur: %.2f | Date: %s",
                    nomParcelle, parcelleId, d.getType(), d.getValeur(), d.getDate()
                );
                alerteSender.sendAlerte(message);
            }
        }
    } }