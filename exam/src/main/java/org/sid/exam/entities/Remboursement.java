package org.sid.exam.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.sid.exam.enums.TypeRemboursement;

import java.util.Date;

@Data
@Entity
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;
    private double montant;

    @Enumerated(EnumType.STRING)
    private TypeRemboursement type;

    @ManyToOne
    private Credit credit;
}