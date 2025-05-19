package org.sid.exam.services;

import org.sid.exam.entities.Remboursement;
import org.sid.exam.repositories.RemboursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RemboursementServiceImpl implements RemboursementService {

    @Autowired
    private RemboursementRepository remboursementRepository;

    @Override
    public Remboursement saveRemboursement(Remboursement remboursement) {
        return remboursementRepository.save(remboursement);
    }

    @Override
    public Remboursement getRemboursementById(Long id) {
        return remboursementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Remboursement> getAllRemboursements() {
        return remboursementRepository.findAll();
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }
}
