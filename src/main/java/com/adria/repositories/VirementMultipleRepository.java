package com.adria.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adria.entities.Compte;
import com.adria.entities.VirementMultiple;


@Repository
public interface VirementMultipleRepository extends JpaRepository<VirementMultiple, Long> {

	Optional<VirementMultiple> findById(Long id);
	
	List<VirementMultiple> findAllByCompte(Compte compte);

}
