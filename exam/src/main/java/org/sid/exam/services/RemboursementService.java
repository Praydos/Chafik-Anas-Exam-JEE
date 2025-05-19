package org.sid.exam.services;

import org.sid.exam.entities.Remboursement;

import java.util.List;

public interface RemboursementService {
    Remboursement saveRemboursement(Remboursement remboursement);
    Remboursement getRemboursementById(Long id);
    List<Remboursement> getAllRemboursements();
    void deleteRemboursement(Long id);
}