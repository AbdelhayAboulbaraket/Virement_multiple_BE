package com.adria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adria.entities.VirementMultipleBeneficiaire;

@Repository
public interface VirementMultipleBeneficiaireRepository extends JpaRepository<VirementMultipleBeneficiaire, Long> {

}
