package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParcelleDTO {
    private Long id;
    private Long exploitationId;
    private String culture;
    private Double surface;
    private String etat;
}