package com.nttdata.estore.repositories;

import com.nttdata.estore.entities.Authority;
import com.nttdata.estore.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);
}
