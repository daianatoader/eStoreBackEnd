package com.nttdata.estore.controllers;
import com.nttdata.estore.entities.Order;
import com.nttdata.estore.repositories.OrderRepository;
import com.nttdata.estore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path="/allOrders")
    public @ResponseBody Iterable<Order> getAllOrders() {
        // This returns a JSON or XML with the users
        return orderService.findAll();
    }
}
