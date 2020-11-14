package com.adria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adria.entities.Abonne;
import com.adria.entities.Beneficiaire;
import com.adria.entities.Compte;
import com.adria.exceptions.ConflictException;
import com.adria.exceptions.NotFoundException;
import com.adria.repositories.AbonneRepository;
import com.adria.repositories.VirementMultipleRepository;

@Service
public class AbonneService {

	@Autowired
	AbonneRepository abonneRepository;
	
	@Autowired
	VirementMultipleRepository virementMultipleRepository;



	//Ajouter un abonn�
	public void addAbonne(Abonne abonne)
	{
		if(abonneRepository.findByUsername(abonne.getUsername()).isPresent()) 
			throw new ConflictException("Un abonn� avec le username "+abonne.getUsername()+" existe d�j�.");
		
		abonne.setPassword(new BCryptPasswordEncoder().encode(abonne.getPassword()));
		
		abonneRepository.save(abonne);
	}
	
	
	
	
	public Abonne getAbonne(Long id)
	{
		Abonne abonne = abonneRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun abonn� avec l'id "+id+" trouv�."));
		
		return abonne;
	}
	
	
	
	public List<Abonne> getAbonnes()
	{
		List<Abonne> abonnes = abonneRepository.findAll();
		if(abonnes.isEmpty()) throw new NotFoundException("Aucun abonn� trouv�.");
		
		return abonnes;
	}
	
	
	
	
	
	
	//Liste des comptes d'un abonn�
	public List<Compte> getComptes(Long id)
	{
		Abonne abonne = abonneRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun abonn� avec l'id "+id+" trouv�."));
		if(abonne.getComptes().isEmpty()) throw new NotFoundException("Cet abonn� n'a aucun compte.");
		
		return abonne.getComptes();
	}
	
	
	
	//Liste des b�n�ficiaires d'un abonn�
		public List<Beneficiaire> getBeneficiaires(Long id)
		{
			Abonne abonne = abonneRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Aucun abonn� avec l'id "+id+" trouv�."));
			if(abonne.getBeneficiaires().isEmpty()) throw new NotFoundException("Cet abonn� n'a aucun b�n�ficiaire.");
			
			return abonne.getBeneficiaires();
		}
	
	
	
	
	
	//Trouver un abonn� par son username
	public Abonne getByUsername(String username)
	{
		return abonneRepository.findByUsername(username)
				.orElseThrow(() -> new NotFoundException("Aucun abonn� avec le username "+username+" trouv�."));
	}
	
	
	
	
	
	
	//Supprimer un abonn�
	public void deleteAbonne(Long id)
	{
		if(!abonneRepository.findById(id).isPresent()) throw new NotFoundException("Aucun abonn� avec l'id "+id+" n'est trouv�.");
		abonneRepository.delete(id);
	}
	
	
	
	
	
}
