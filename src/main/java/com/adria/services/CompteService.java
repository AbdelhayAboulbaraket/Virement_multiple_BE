package com.adria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.adria.entities.Compte;
import com.adria.entities.VirementMultiple;
import com.adria.exceptions.ConflictException;
import com.adria.exceptions.NotFoundException;
import com.adria.repositories.CompteRepository;
import com.adria.repositories.VirementMultipleRepository;

@Service
public class CompteService {

	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	VirementMultipleRepository virementMultipleRepository;


	
	public Compte getCompte(Long id)
	{
		
		Compte compte = compteRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun compte avec l'id "+id+" trouvé"));
		
		return compte;
	}
	
	
	public List<Compte> getComptes()
	{
		List<Compte> comptes= compteRepository.findAll();
				
		if(comptes.isEmpty())  throw new NotFoundException("Aucun compte trouvé");
		
		return comptes;
	}
	
	
	//Compte par numeroCompte
	public Compte getByNumeroCompte(String numeroCompte)
	{
		Compte compte = compteRepository.findByNumeroCompte(numeroCompte)
				.orElseThrow(() -> new NotFoundException("Ce compte n'existe pas"));
				
		return compte;
	}
	




	//Ajouter compte
	public void addCompte(Compte compte)
	{
		if(compteRepository.findByNumeroCompte(compte.getNumeroCompte()).isPresent()) {
			throw new ConflictException("Un compte avec le NumeroCompte "+compte.getNumeroCompte()+" existe déjà ");
		}

		compteRepository.save(compte);

	}
	
	


	public void deleteCompte(Long id)
	{

		//vérifier l'existence de l'compte
		if(!compteRepository.findById(id).isPresent()) throw new NotFoundException("Aucun compte avec l'id "+id+" n'est trouvé");
		compteRepository.delete(id);

	}
	
	
	public List<VirementMultiple> virementsMultiples(Long id)
	{
		Compte compte = compteRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun compte avec l'id "+id+" trouvé"));
		
		List<VirementMultiple> virementsMultiples = virementMultipleRepository.findAllByCompte(compte);
		
		if(virementsMultiples.isEmpty()) throw new NotFoundException("Aucun virement multiple effectué");
		
		return virementsMultiples;		
		
	}


}
