package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Client;
import com.nttdata.estore.entities.Order;
import com.nttdata.estore.services.ClientService;
import com.nttdata.estore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class ShoppingCartController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/cart")
    public @ResponseBody Iterable<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping(path = "/cart/{id}")
    @Transactional
    public ResponseEntity getOrder(@PathVariable("id") int id) {
        Client client = clientService.getClient(1);
        Order order = orderService.getOpenOrderForClient(client);
        if (order != null) {
            order.updatePrice();
        }
        return ResponseEntity.ok(order);
    }
}
