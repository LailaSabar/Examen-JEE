package org.sid.feign;

import org.sid.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CLIENT-SERVICE")
public interface ClientRestClient {
	
	@GetMapping(path="/clients/{id}")
	Client getAbonneById(@PathVariable(name="id") Long id);
	
    @GetMapping("/clients")
    PagedModel<Client> findAll();
	

}
