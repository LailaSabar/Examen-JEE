package org.sid.services;

import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.model.Client;
import org.sid.reposotories.CompteRepository;
import org.sid.reposotories.OperationRepository;
import org.springframework.hateoas.PagedModel;

public interface CompteService {
	
	Compte versement(Compte compte, double montant, OperationRepository operationRepository);
	Compte retrait(Compte compte,double montant, OperationRepository operationRepository);
	Compte virement(Compte compte_source,Compte compte_destination,double montant, OperationRepository operationRepository);
	PagedModel<Operation> afficherOperations(Long id_compte, OperationRepository operationRepository);
	Compte activer (Compte compte);
	Compte suspendre (Compte compte);

	

}
