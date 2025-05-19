package org.sid.exam.dtos;

import lombok.Data;
import java.util.Date;

import lombok.Data;
import java.util.Date;

@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private String statut; // Enum as String
    private Date dateAcception;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    private String specificDetails; // To hold special credit details like "motif" or "typeBien"
    private Long clientId; // ID of the associated client
}