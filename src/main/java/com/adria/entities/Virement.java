package com.adria.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Virement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	Date dateCreation;
	
	Date dateExecution;
	
	BigDecimal montant;
	
	String motif;
	
	String statut;
	
	@ManyToOne
	Compte compte;
	
	@ManyToOne
	Abonne abonne;
	
	

	public Virement() {
		super();
	}



	public Virement(Long id, Date dateCreation, Date dateExecution, BigDecimal montant, String motif, Compte compte,
			Abonne abonne, String statut) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.dateExecution = dateExecution;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
		this.abonne = abonne;
		this.statut = statut;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDateCreation() {
		return dateCreation;
	}



	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}



	public Date getDateExecution() {
		return dateExecution;
	}



	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}



	public BigDecimal getMontant() {
		return montant;
	}



	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}



	public String getMotif() {
		return motif;
	}



	public void setMotif(String motif) {
		this.motif = motif;
	}



	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}



	public Abonne getAbonne() {
		return abonne;
	}



	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
	
	
	
	
	
}