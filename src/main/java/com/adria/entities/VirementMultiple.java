package com.adria.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class VirementMultiple extends Virement{

	Integer nombreBeneficiaires;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="virementMultiple")
	List<VirementMultipleBeneficiaire> virementMultipleBeneficiaires;

	
	

	public VirementMultiple() {
		super();
	}



	public VirementMultiple(Integer nombreBeneficiaires,
			List<VirementMultipleBeneficiaire> virementMultipleBeneficiaires) {
		super();
		this.nombreBeneficiaires = nombreBeneficiaires;
		this.virementMultipleBeneficiaires = virementMultipleBeneficiaires;
	}



	public Integer getNombreBeneficiaires() {
		return nombreBeneficiaires;
	}



	public void setNombreBeneficiaires(Integer nombreBeneficiaires) {
		this.nombreBeneficiaires = nombreBeneficiaires;
	}



	public List<VirementMultipleBeneficiaire> getVirementMultipleBeneficiaires() {
		return virementMultipleBeneficiaires;
	}



	public void setVirementMultipleBeneficiaires(List<VirementMultipleBeneficiaire> virementMultipleBeneficiaires) {
		this.virementMultipleBeneficiaires = virementMultipleBeneficiaires;
	}

	
	
	
}
