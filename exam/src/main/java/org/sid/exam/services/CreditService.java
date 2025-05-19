package org.sid.exam.services;

import org.sid.exam.entities.Credit;

import java.util.List;

public interface CreditService {
    Credit saveCredit(Credit credit);
    Credit getCreditById(Long id);
    List<Credit> getAllCredits();
    void deleteCredit(Long id);
}