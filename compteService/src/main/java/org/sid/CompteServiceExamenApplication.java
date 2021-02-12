package org.sid;


import java.util.Date;

import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.model.Client;
import org.sid.reposotories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableEurekaClient
public class CompteServiceExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceExamenApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration) {
		restConfiguration.exposeIdsFor(Compte.class);
		
		Client client= new Client(1l, "Laila", "lailasb2@gmail.com");
		
	    return args -> {
	    	compteRepository.save(new Compte(null, 3999,new Date(),"ACTIVE","EPARGNE", 1l, client,null));
	    	compteRepository.save(new Compte(null, 5999,new Date(),"ACTIVE","COURANT", 1l, client,null));	
	    	compteRepository.save(new Compte(null, 6999,new Date(),"ACTIVE","EPARGNE", 1l, client,null));
	    	compteRepository.findAll().forEach(c->{
	        		System.out.println(c.toString());
	    });
	};


}


}
