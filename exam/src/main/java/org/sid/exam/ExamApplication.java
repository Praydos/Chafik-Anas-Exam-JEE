package org.sid.exam;

import org.sid.exam.entities.Client;
import org.sid.exam.entities.CreditImmobilier;
import org.sid.exam.entities.CreditPersonnel;
import org.sid.exam.entities.Remboursement;
import org.sid.exam.enums.StatutCredit;
import org.sid.exam.enums.TypeRemboursement;
import org.sid.exam.services.ClientService;
import org.sid.exam.services.CreditService;
import org.sid.exam.services.RemboursementService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

	@Autowired
	private ClientService clientService;

	@Autowired
	private CreditService creditService;

	@Autowired
	private RemboursementService remboursementService;

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// STEP 1: Create Clients
		Client client1 = new Client();
		client1.setNom("John Doe");
		client1.setEmail("john.doe@example.com");

		Client client2 = new Client();
		client2.setNom("Jane Smith");
		client2.setEmail("jane.smith@example.com");

		client1 = clientService.saveClient(client1);
		client2 = clientService.saveClient(client2);

		System.out.println("Clients saved: " + Arrays.asList(client1, client2));

		// STEP 2: Create Credits
		CreditPersonnel creditPersonnel = new CreditPersonnel();
		creditPersonnel.setDateDemande(new Date());
		creditPersonnel.setStatut(StatutCredit.EN_COURS);
		creditPersonnel.setMontant(10000);
		creditPersonnel.setDureeRemboursement(24);
		creditPersonnel.setTauxInteret(5.2);
		creditPersonnel.setMotif("Achat de voiture");
		creditPersonnel.setClient(client1);

		CreditImmobilier creditImmobilier = new CreditImmobilier();
		creditImmobilier.setDateDemande(new Date());
		creditImmobilier.setStatut(StatutCredit.ACCEPTE);
		creditImmobilier.setMontant(150000);
		creditImmobilier.setDureeRemboursement(360);
		creditImmobilier.setTauxInteret(4.1);
		creditImmobilier.setTypeBien("Appartement");
		creditImmobilier.setClient(client2);

		creditPersonnel = (CreditPersonnel) creditService.saveCredit(creditPersonnel);
		creditImmobilier = (CreditImmobilier) creditService.saveCredit(creditImmobilier);

		System.out.println("Credits saved: " + Arrays.asList(creditPersonnel, creditImmobilier));

		// STEP 3: Create Remboursements
		Remboursement remboursement1 = new Remboursement();
		remboursement1.setDate(new Date());
		remboursement1.setMontant(450);
		remboursement1.setType(TypeRemboursement.MENSUALITE);
		remboursement1.setCredit(creditPersonnel);

		Remboursement remboursement2 = new Remboursement();
		remboursement2.setDate(new Date());
		remboursement2.setMontant(750);
		remboursement2.setType(TypeRemboursement.REMBOURSEMENT_ANTICIPE);
		remboursement2.setCredit(creditImmobilier);

		remboursement1 = remboursementService.saveRemboursement(remboursement1);
		remboursement2 = remboursementService.saveRemboursement(remboursement2);

//		System.out.println("Remboursements saved: " + Arrays.asList(remboursement1, remboursement2));
//
//		// STEP 4: Retrieve Data
//		System.out.println("List of all clients: " + clientService.getAllClients());
//		System.out.println("List of all credits: " + creditService.getAllCredits());
//		System.out.println("List of all remboursements: " + remboursementService.getAllRemboursements());
	}
}