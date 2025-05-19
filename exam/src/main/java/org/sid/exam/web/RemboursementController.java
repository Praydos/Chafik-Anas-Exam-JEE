package org.sid.exam.web;

import org.sid.exam.entities.Remboursement;
import org.sid.exam.services.RemboursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.sid.exam.dtos.RemboursementDTO;
import org.sid.exam.entities.Remboursement;
import org.sid.exam.services.RemboursementService;
import org.sid.exam.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/remboursements")
@CrossOrigin
public class RemboursementController {

    @Autowired
    private RemboursementService remboursementService;

    // Create or update a remboursement
    @PostMapping
    public RemboursementDTO addRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        Remboursement remboursement = Mapper.mapToRemboursement(remboursementDTO);
        Remboursement savedRemboursement = remboursementService.saveRemboursement(remboursement);
        return Mapper.mapToRemboursementDTO(savedRemboursement);
    }

    // Get a remboursement by its ID
    @GetMapping("/{id}")
    public RemboursementDTO getRemboursementById(@PathVariable Long id) {
        Remboursement remboursement = remboursementService.getRemboursementById(id);
        return remboursement != null ? Mapper.mapToRemboursementDTO(remboursement) : null;
    }

    // Get all remboursements
    @GetMapping
    public List<RemboursementDTO> getAllRemboursements() {
        return remboursementService.getAllRemboursements()
                .stream()
                .map(Mapper::mapToRemboursementDTO)
                .collect(Collectors.toList());
    }

    // Delete a remboursement by ID
    @DeleteMapping("/{id}")
    public void deleteRemboursement(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
    }
}