package com.nttdata.estore.services;

import com.nttdata.estore.entities.Order;
import com.nttdata.estore.entities.OrderStatus;
import com.nttdata.estore.entities.User;
import com.nttdata.estore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order getOrder(int id) {
        return orderRepository.findOne(id);
    }

    public void saveOrUpdateOrder(Order order) { orderRepository.save(order); }

    public Order getOpenOrderForClient(User user){
        List<Order> orders = new ArrayList<>();
        findAll().forEach(orders::add);
        return orders.stream() //
                .filter(o -> o.getOrderStatus() == OrderStatus.OPEN && o.getUser().equals(user)) //
                .findFirst().orElse(null);
    }
}