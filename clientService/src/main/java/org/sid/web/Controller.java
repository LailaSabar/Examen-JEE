package org.sid.web;

import org.sid.repositories.ClientRepository;

import javax.servlet.http.HttpServletRequest;

import org.sid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@Autowired
	private ClientRepository clientRepository;
	
	   @GetMapping("/clients/{name}")
	    public Client getBill(HttpServletRequest request,@PathVariable(name="name") String name) {
	    	Client client=clientRepository.findByName(name);
	    	return client;
	    }
}
