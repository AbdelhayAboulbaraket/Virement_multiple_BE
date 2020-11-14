package com.adria.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Beneficiaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	String nom;
	
	String prenom;
	
	String numeroCompte;
	
	@ManyToOne
	Abonne abonne;
	
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="beneficiaire")
	List<VirementMultipleBeneficiaire> virementMultipleBeneficiaires;


	public Beneficiaire() {
		super();
	}


	public Beneficiaire(Long id, String nom, String prenom, String numeroCompte, Abonne abonne,
			List<VirementMultipleBeneficiaire> virementMultipleBeneficiaires) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroCompte = numeroCompte;
		this.abonne = abonne;
		this.virementMultipleBeneficiaires = virementMultipleBeneficiaires;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNumeroCompte() {
		return numeroCompte;
	}


	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}


	public Abonne getAbonne() {
		return abonne;
	}


	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}


	public List<VirementMultipleBeneficiaire> getVirementMultipleBeneficiaires() {
		return virementMultipleBeneficiaires;
	}


	public void setVirementMultipleBeneficiaires(List<VirementMultipleBeneficiaire> virementMultipleBeneficiaires) {
		this.virementMultipleBeneficiaires = virementMultipleBeneficiaires;
	}


	
	

}