package org.sid.exam.services;

import org.sid.exam.entities.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClients();
    void deleteClient(Long id);
}