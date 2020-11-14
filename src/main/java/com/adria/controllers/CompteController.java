package com.adria.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.adria.entities.Compte;
import com.adria.entities.VirementMultiple;
import com.adria.services.CompteService;


@RestController
@CrossOrigin(origins="http://localhost:3000")
public class CompteController {
	
	@Autowired
	CompteService service;
	
	
	//GET
			@GetMapping("/compte")
			@ResponseStatus(HttpStatus.OK)
			public Compte getComptes(@RequestParam(value="id") Long id)
			{
				return service.getCompte(id);
			}
			
			
			@GetMapping("/comptes")
			@ResponseStatus(HttpStatus.OK)
			public List<Compte> getComptes()
			{
				return service.getComptes();
			}
			
			
			@GetMapping("/compte/{numeroCompte}")
			@ResponseStatus(HttpStatus.OK)
			public Compte getCompteByNumero(@PathVariable(value="numeroCompte") String numeroCompte)
			{
				return service.getByNumeroCompte(numeroCompte);
			}
			
			
	
		//POST
			
			@PostMapping("/compte")
			@ResponseStatus(HttpStatus.CREATED)
			public void addCompte(@RequestBody Compte compte)
			{
				service.addCompte(compte);
			}
		
		
		
			
		//DELETE
			
			@DeleteMapping("/compte/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void deleteCompte(@PathVariable(value="id") Long id)
			{
				service.deleteCompte(id);
			}
			
			
			
			//Liste virements multiples
			
			@GetMapping("/compte/{id}/virementsMultiples")
			public List<VirementMultiple> virementsMultiples(@PathVariable(value="id") Long id)
			{
				return service.virementsMultiples(id);
			}
	

}

