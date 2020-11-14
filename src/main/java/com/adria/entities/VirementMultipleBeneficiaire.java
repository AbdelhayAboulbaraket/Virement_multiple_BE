package com.adria.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VirementMultipleBeneficiaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	BigDecimal montant;
	
	@ManyToOne
	Beneficiaire beneficiaire;
	
	@JsonIgnore
	@ManyToOne
	VirementMultiple virementMultiple;
	
	
	

	public VirementMultipleBeneficiaire() {
		super();
	}




	public VirementMultipleBeneficiaire(Long id, BigDecimal montant, Beneficiaire beneficiaire,
			VirementMultiple virementMultiple) {
		super();
		this.id = id;
		this.montant = montant;
		this.beneficiaire = beneficiaire;
		this.virementMultiple = virementMultiple;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public BigDecimal getMontant() {
		return montant;
	}




	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}




	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}




	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}




	public VirementMultiple getVirementMultiple() {
		return virementMultiple;
	}




	public void setVirementMultiple(VirementMultiple virementMultiple) {
		this.virementMultiple = virementMultiple;
	}
	
	
	
	
	
	
}
