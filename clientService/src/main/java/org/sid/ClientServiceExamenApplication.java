package org.sid;

import org.sid.entities.Client;
import org.sid.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableEurekaClient
public class ClientServiceExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceExamenApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration) {
		restConfiguration.exposeIdsFor(Client.class);
	    return args -> {
	    	clientRepository.save(new Client(null, "Laila", "lailasb2@gmail.com"));
	    	clientRepository.save(new Client(null, "Rim", "rim@gmail.com"));
	    	clientRepository.save(new Client(null, "Oussama", "oussama@gmail.com"));
	    	clientRepository.findAll().forEach(c->{
	        		System.out.println(c.toString());
	    });
	};


}

}
