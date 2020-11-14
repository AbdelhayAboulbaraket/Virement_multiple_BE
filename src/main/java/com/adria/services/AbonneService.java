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



	//Ajouter un abonné
	public void addAbonne(Abonne abonne)
	{
		if(abonneRepository.findByUsername(abonne.getUsername()).isPresent()) 
			throw new ConflictException("Un abonné avec le username "+abonne.getUsername()+" existe déjà.");
		
		abonne.setPassword(new BCryptPasswordEncoder().encode(abonne.getPassword()));
		
		abonneRepository.save(abonne);
	}
	
	
	
	
	public Abonne getAbonne(Long id)
	{
		Abonne abonne = abonneRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun abonné avec l'id "+id+" trouvé."));
		
		return abonne;
	}
	
	
	
	public List<Abonne> getAbonnes()
	{
		List<Abonne> abonnes = abonneRepository.findAll();
		if(abonnes.isEmpty()) throw new NotFoundException("Aucun abonné trouvé.");
		
		return abonnes;
	}
	
	
	
	
	
	
	//Liste des comptes d'un abonné
	public List<Compte> getComptes(Long id)
	{
		Abonne abonne = abonneRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun abonné avec l'id "+id+" trouvé."));
		if(abonne.getComptes().isEmpty()) throw new NotFoundException("Cet abonné n'a aucun compte.");
		
		return abonne.getComptes();
	}
	
	
	
	//Liste des bénéficiaires d'un abonné
		public List<Beneficiaire> getBeneficiaires(Long id)
		{
			Abonne abonne = abonneRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Aucun abonné avec l'id "+id+" trouvé."));
			if(abonne.getBeneficiaires().isEmpty()) throw new NotFoundException("Cet abonné n'a aucun bénéficiaire.");
			
			return abonne.getBeneficiaires();
		}
	
	
	
	
	
	//Trouver un abonné par son username
	public Abonne getByUsername(String username)
	{
		return abonneRepository.findByUsername(username)
				.orElseThrow(() -> new NotFoundException("Aucun abonné avec le username "+username+" trouvé."));
	}
	
	
	
	
	
	
	//Supprimer un abonné
	public void deleteAbonne(Long id)
	{
		if(!abonneRepository.findById(id).isPresent()) throw new NotFoundException("Aucun abonné avec l'id "+id+" n'est trouvé.");
		abonneRepository.delete(id);
	}
	
	
	
	
	
}
