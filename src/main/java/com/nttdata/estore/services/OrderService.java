package com.nttdata.estore.services;

import com.nttdata.estore.entities.Order;
import com.nttdata.estore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order getOrder (int id){
        return orderRepository.findOne(id);
    }

    public void saveOrUpdateOrder(Order order) { orderRepository.save(order); }
}