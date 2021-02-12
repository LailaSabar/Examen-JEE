package org.sid.services;

import java.util.Date;
import java.util.Optional;

import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.model.Client;
import org.sid.reposotories.CompteRepository;
import org.sid.reposotories.OperationRepository;
import org.springframework.hateoas.PagedModel;

public class CompteServiceImpl implements CompteService {

	@Override
	public Compte versement(Compte compte, double montant, OperationRepository operationRepository) {
		compte.setSolde(compte.getSolde()+montant);
		operationRepository.save(new Operation(null, new Date(), montant, "DEBIT", compte.getClient().getCode(), compte.getClient(), compte.getCode(), compte));
		return compte;
	}

	@Override
	public Compte retrait(Compte compte, double montant, OperationRepository operationRepository) {
		compte.setSolde(compte.getSolde()-montant);
		operationRepository.save(new Operation(null, new Date(), montant, "CREDIT", compte.getClient().getCode(), compte.getClient(), compte.getCode(), compte));
		return compte;
	}

	@Override
	public Compte virement(Compte compte_source, Compte compte_destination, double montant, OperationRepository operationRepository) {
		compte_source.setSolde(compte_source.getSolde()-montant);
		operationRepository.save(new Operation(null, new Date(), montant, "CREDIT", compte_source.getClient().getCode(), compte_source.getClient(), compte_source.getCode(), compte_source));
		compte_destination.setSolde(compte_destination.getSolde()+montant);
		operationRepository.save(new Operation(null, new Date(), montant, "DEBIT", compte_destination.getClient().getCode(), compte_destination.getClient(), compte_destination.getCode(), compte_destination));
		return compte_destination;
	}

	@Override
	public PagedModel<Operation> afficherOperations(Long id_compte, OperationRepository operationRepository) {	
		return operationRepository.findByIdCompte(id_compte);
	}

	@Override
	public Compte activer(Compte compte) {
		compte.setEtat("ACTIVE");
		
		return compte;
	}

	@Override
	public Compte suspendre(Compte compte) {
		
		compte.setEtat("SUSPENDU");
		
		return compte;
	}

	

}
