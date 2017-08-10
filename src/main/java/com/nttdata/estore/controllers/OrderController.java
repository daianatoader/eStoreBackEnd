package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Order;
import com.nttdata.estore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/allOrders")
    public @ResponseBody
    Iterable<Order> getAllOrders() {
        return orderService.findAll();
    }
}
