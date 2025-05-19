package org.sid.exam.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private double montant;
    private String type; // Type as String (MENSUALITE, REMBOURSEMENT_ANTICIPE)
    private Long creditId; // The associated credit ID
}