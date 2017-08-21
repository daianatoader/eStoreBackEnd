package com.nttdata.estore.controllers;

import com.nttdata.estore.entities.Order;
import com.nttdata.estore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/orders")
    public @ResponseBody
    Iterable<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping(path = "/orders/{id}")
    public ResponseEntity getOrder(@PathVariable("id") int id) {
        Order order = orderService.getOrder(id);
        if (null == order) {
            return new ResponseEntity("No Order found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(order, HttpStatus.OK);
    }

    @PostMapping(path = "/orders")
    public ResponseEntity createOrder(@RequestBody Order order) {
        orderService.saveOrUpdateOrder(order);
        return new ResponseEntity(order, HttpStatus.OK);
    }

    @PutMapping(path = "/orders/{id}")
    public ResponseEntity updateOrder(@PathVariable int id, @RequestBody Order order) {
        // TODO check method
        Order oldOrder = orderService.getOrder(id);
        if (null == oldOrder) {
            return new ResponseEntity("No Order found for ID " + id, HttpStatus.NOT_FOUND);
        }
        oldOrder = order;
        orderService.saveOrUpdateOrder(oldOrder);
        return new ResponseEntity(oldOrder, HttpStatus.OK);
    }
}
