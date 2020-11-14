package com.adria.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adria.entities.Beneficiaire;
import com.adria.exceptions.ConflictException;
import com.adria.exceptions.NotFoundException;
import com.adria.repositories.BeneficiaireRepository;

@Service
public class BeneficiaireService {
	
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;
	
	
	
	public void addBeneficiaire(Beneficiaire beneficiaire)
	{
		if(beneficiaireRepository.findByNumeroCompte(beneficiaire.getNumeroCompte()).isPresent()) 
			throw new ConflictException("Un b�n�ficiaire avec le num�ro de compte "+beneficiaire.getNumeroCompte()+" existe d�j�.");
		
		beneficiaireRepository.save(beneficiaire);
		
	}
	
	
	public Beneficiaire getBeneficiaire(Long id)
	{
		
		Beneficiaire beneficiaire = beneficiaireRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun b�n�ficiaire avec l'id "+id+" trouv�."));
		
		return beneficiaire;
	}
	
	
	
	
	public void deleteBeneficiaire(Long id)
	{
		if(!beneficiaireRepository.findById(id).isPresent())  throw new NotFoundException("Aucun b�n�ficiaire avec l'id "+id+" trouv�.");
		beneficiaireRepository.delete(id);
	}

}
