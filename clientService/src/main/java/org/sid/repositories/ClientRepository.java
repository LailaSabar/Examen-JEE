package org.sid.repositories;

import java.util.List;

import org.sid.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
	Client findByName(String name);
}

