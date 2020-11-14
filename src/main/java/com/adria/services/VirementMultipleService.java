package com.adria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adria.entities.Beneficiaire;
import com.adria.entities.VirementMultiple;
import com.adria.entities.VirementMultipleBeneficiaire;
import com.adria.exceptions.NotFoundException;
import com.adria.repositories.BeneficiaireRepository;
import com.adria.repositories.VirementMultipleBeneficiaireRepository;
import com.adria.repositories.VirementMultipleRepository;

@Service
public class VirementMultipleService {
	
	@Autowired
	VirementMultipleRepository virementMultipleRepository;
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;
	
	@Autowired
	VirementMultipleBeneficiaireRepository virementMultipleBeneficiaireRepository;
	
	
	
	
	
	public void EffectuerVirementMultiple(VirementMultiple virementMultiple)
	{
		List<VirementMultipleBeneficiaire> list = new ArrayList<VirementMultipleBeneficiaire>();
		VirementMultipleBeneficiaire virementMultipleBeneficiaire= new VirementMultipleBeneficiaire();
		Beneficiaire beneficiaire = new Beneficiaire();
		Long idBeneficiaire=null;
		
		virementMultiple =virementMultipleRepository.save(virementMultiple);
		
		for(int i=0; i<virementMultiple.getNombreBeneficiaires(); i++)
		{
			virementMultipleBeneficiaire = virementMultiple.getVirementMultipleBeneficiaires().get(i);
			idBeneficiaire = virementMultipleBeneficiaire.getBeneficiaire().getId();
			beneficiaire = beneficiaireRepository.findOne(idBeneficiaire);
			virementMultipleBeneficiaire.setBeneficiaire(beneficiaire);
			virementMultipleBeneficiaire.setVirementMultiple(virementMultiple);
			
			virementMultipleBeneficiaire = virementMultipleBeneficiaireRepository.save(virementMultipleBeneficiaire);
			list.add(virementMultipleBeneficiaire);

		}
		
		virementMultiple.setVirementMultipleBeneficiaires(list);
		
		virementMultipleRepository.save(virementMultiple);
		
		
	}
	
	
	public VirementMultiple getVirementMultiple(Long id)
	{
		VirementMultiple virementMultiple = virementMultipleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun virement multiple avec l'id "+id+" trouvé."));
		
		return virementMultiple;
	}


	public List<VirementMultipleBeneficiaire> getVirementMultipleBeneficiaires(Long id) {

		VirementMultiple virementMultiple = virementMultipleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Aucun virement multiple avec l'id "+id+" trouvé."));
		List<VirementMultipleBeneficiaire> virementMultipleBeneficiaires = virementMultiple.getVirementMultipleBeneficiaires();
		
		return virementMultipleBeneficiaires;
	}
	
	
	
	public void confirmerEtSigner(Long id, String password)
	{
		//Abonne abonne = new Abonne(); //à modifier : l'abonné en session
		
		
		VirementMultiple virementMultiple = virementMultipleRepository.findOne(id);
		//if(abonne.getPassword().equals(new BCryptPasswordEncoder().encode(password))) 
			{
				virementMultiple.setStatut("Confirmé et Signé");
				virementMultipleRepository.save(virementMultiple);
			}
//		else
//			throw new ConflictException("Mot de passe incorrect.");
		
	}
	
	

}
