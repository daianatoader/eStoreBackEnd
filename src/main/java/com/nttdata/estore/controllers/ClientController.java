package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Client;
import com.nttdata.estore.repositories.ClientRepository;
import com.nttdata.estore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(path = "/clients")
    public @ResponseBody
    Iterable<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping(path = "/clients/{id}")
    public ResponseEntity getClient(@PathVariable("id") int id) {
        Client client = clientService.getById(id);
        if (null == client) {
            return new ResponseEntity("No Client found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(client, HttpStatus.OK);
    }
    @DeleteMapping(path= "/clients/{id}")
    public ResponseEntity deleteClient(@PathVariable int id){
        clientService.deleteClient(id);
        return new ResponseEntity(id,HttpStatus.OK);
    }

    @PostMapping(path = "/clients")
    public ResponseEntity createClient(@RequestBody Client client) {
        clientService.createClient(client);
        return new ResponseEntity(client, HttpStatus.OK);
    }

    @PutMapping(path = "/clients/{id}")
    public ResponseEntity updateClient(@PathVariable int id, @RequestBody Client client) {
        Client oldClient = clientService.getById(id);
        oldClient = client;
        clientService.createClient(oldClient);
        if (null == oldClient) {
            return new ResponseEntity("No Client found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(oldClient, HttpStatus.OK);
    }
}
