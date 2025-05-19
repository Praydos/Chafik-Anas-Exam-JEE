package org.sid.exam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.sid.exam.entities.Credit;
import org.sid.exam.services.CreditService;


import org.sid.exam.dtos.CreditDTO;
import org.sid.exam.entities.Credit;
import org.sid.exam.services.CreditService;
import org.sid.exam.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/credits")
@CrossOrigin
public class CreditController {

    @Autowired
    private CreditService creditService;

    // Create or update a credit (Can handle different types of credits)
    @PostMapping
    public CreditDTO addCredit(@RequestBody CreditDTO creditDTO) {
        Credit credit = Mapper.mapToCredit(creditDTO, new Credit());
        Credit savedCredit = creditService.saveCredit(credit);
        return Mapper.mapToCreditDTO(savedCredit);
    }

    // Get a credit by its ID
    @GetMapping("/{id}")
    public CreditDTO getCreditById(@PathVariable Long id) {
        Credit credit = creditService.getCreditById(id);
        return credit != null ? Mapper.mapToCreditDTO(credit) : null;
    }

    // Get all credits
    @GetMapping
    public List<CreditDTO> getAllCredits() {
        return creditService.getAllCredits()
                .stream()
                .map(Mapper::mapToCreditDTO)
                .collect(Collectors.toList());
    }

    // Delete a credit by ID
    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
    }
}