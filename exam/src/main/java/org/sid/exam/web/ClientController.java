package org.sid.exam.web;

import org.sid.exam.dtos.ClientDTO;
import org.sid.exam.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import org.sid.exam.entities.Client;
import org.sid.exam.services.ClientService;


@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

//    @PostMapping
//    public Client addClient(@RequestBody Client client) {
//        return clientService.saveClient(client);
//    }
    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        Client client = Mapper.mapToClient(clientDTO);
        Client savedClient = clientService.saveClient(client);
        return Mapper.mapToClientDTO(savedClient);
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return client != null ? Mapper.mapToClientDTO(client) : null;
    }

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients().stream()
                .map(Mapper::mapToClientDTO)
                .collect(Collectors.toList());
    }
}

//    @DeleteMapping("/{id}")
//    public void deleteClient(@PathVariable Long id) {
//        clientService.deleteClient(id);
//    }
