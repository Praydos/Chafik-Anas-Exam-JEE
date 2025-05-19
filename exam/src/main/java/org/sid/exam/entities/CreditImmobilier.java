package org.sid.exam.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {
    private String typeBien; // Appartement, Maison ou Local Commercial
}