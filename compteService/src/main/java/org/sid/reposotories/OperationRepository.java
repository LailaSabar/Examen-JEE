package org.sid.reposotories;

import org.sid.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.PagedModel;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation,Long> {
	PagedModel<Operation> findByIdCompte(Long id_compte);

}
