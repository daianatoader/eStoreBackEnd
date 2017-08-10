package com.nttdata.estore.services;

import com.nttdata.estore.entities.Client;
import com.nttdata.estore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client getClient(int id) {
        return clientRepository.findOne(id);
    }

    public void deleteClient(int id) {
        clientRepository.delete(id);
    }

    public void saveOrUpdateClient(Client client) {
        clientRepository.save(client);
    }
}
