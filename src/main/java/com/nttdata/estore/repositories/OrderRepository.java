package com.nttdata.estore.repositories;

import com.nttdata.estore.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
