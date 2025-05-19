package org.sid.exam.mappers;

import org.sid.exam.dtos.ClientDTO;
import org.sid.exam.dtos.CreditDTO;
import org.sid.exam.dtos.RemboursementDTO;
import org.sid.exam.entities.*;
import org.sid.exam.enums.StatutCredit;
import org.sid.exam.enums.TypeRemboursement;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    // Convert Client to ClientDTO
    public static ClientDTO mapToClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setNom(client.getNom());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setCreditIds(client.getCredits() != null
                ? client.getCredits().stream().map(Credit::getId).collect(Collectors.toList())
                : null);
        return clientDTO;
    }

    // Convert Credit to CreditDTO
    public static CreditDTO mapToCreditDTO(Credit credit) {
        CreditDTO creditDTO = new CreditDTO();
        creditDTO.setId(credit.getId());
        creditDTO.setDateDemande(credit.getDateDemande());
        creditDTO.setStatut(credit.getStatut().name());
        creditDTO.setDateAcception(credit.getDateAcception());
        creditDTO.setMontant(credit.getMontant());
        creditDTO.setDureeRemboursement(credit.getDureeRemboursement());
        creditDTO.setTauxInteret(credit.getTauxInteret());
        creditDTO.setClientId(credit.getClient() != null ? credit.getClient().getId() : null);

        // Distinguish the specific details for each credit type
        if (credit instanceof CreditPersonnel) {
            creditDTO.setSpecificDetails("Motif: " + ((CreditPersonnel) credit).getMotif());
        } else if (credit instanceof CreditImmobilier) {
            creditDTO.setSpecificDetails("Type de Bien: " + ((CreditImmobilier) credit).getTypeBien());
        } else if (credit instanceof CreditProfessionnel) {
            CreditProfessionnel creditProfessionnel = (CreditProfessionnel) credit;
            creditDTO.setSpecificDetails("Motif: " + creditProfessionnel.getMotif() +
                    ", Raison Sociale: " + creditProfessionnel.getRaisonSociale());
        }

        return creditDTO;
    }

    // Convert Remboursement to RemboursementDTO
    public static RemboursementDTO mapToRemboursementDTO(Remboursement remboursement) {
        RemboursementDTO remboursementDTO = new RemboursementDTO();
        remboursementDTO.setId(remboursement.getId());
        remboursementDTO.setDate(remboursement.getDate());
        remboursementDTO.setMontant(remboursement.getMontant());
        remboursementDTO.setType(remboursement.getType().name());
        remboursementDTO.setCreditId(remboursement.getCredit() != null ? remboursement.getCredit().getId() : null);
        return remboursementDTO;
    }

    // Convert ClientDTO to Client
    public static Client mapToClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());
        // Credits list is not set as it is assumed to be managed by another process
        return client;
    }

    // Convert CreditDTO to Credit (Basic Mapping; No specific details)
    public static Credit mapToCredit(CreditDTO creditDTO, Credit credit) {
        credit.setId(creditDTO.getId());
        credit.setDateDemande(creditDTO.getDateDemande());
        credit.setStatut(StatutCredit.valueOf(creditDTO.getStatut()));
        credit.setDateAcception(creditDTO.getDateAcception());
        credit.setMontant(creditDTO.getMontant());
        credit.setDureeRemboursement(creditDTO.getDureeRemboursement());
        credit.setTauxInteret(creditDTO.getTauxInteret());
        // Specific details are ignored here
        return credit;
    }

    // Convert RemboursementDTO to Remboursement
    public static Remboursement mapToRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = new Remboursement();
        remboursement.setId(remboursementDTO.getId());
        remboursement.setDate(remboursementDTO.getDate());
        remboursement.setMontant(remboursementDTO.getMontant());
        remboursement.setType(TypeRemboursement.valueOf(remboursementDTO.getType()));
        // Credit is not set as it is assumed to be managed by another process
        return remboursement;
    }
}