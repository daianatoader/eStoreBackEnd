package com.nttdata.estore.repositories;

import com.nttdata.estore.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
