package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Order;
import com.nttdata.estore.entities.User;
import com.nttdata.estore.services.OrderService;
import com.nttdata.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class ShoppingCartController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/cart")
    public @ResponseBody Iterable<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping(path = "/cart/{id}")
    @Transactional
    public ResponseEntity getOrder(@PathVariable("id") int id) {
        User user = userService.getUser(1);
        Order order = orderService.getOpenOrderForClient(user);
        if (order != null) {
            order.updatePrice();
        }
        return ResponseEntity.ok(order);
    }
}
