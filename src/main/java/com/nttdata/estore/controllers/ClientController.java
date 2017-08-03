package com.nttdata.estore.controllers;
import com.nttdata.estore.entities.Client;
import com.nttdata.estore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/client")
public class ClientController {

    @Autowired
    private ClientRepository clientService;

    @GetMapping(path="/allClients")
    public @ResponseBody Iterable<Client> getAllClients() {
        // This returns a JSON or XML with the users
        return clientService.findAll();
    }
}
