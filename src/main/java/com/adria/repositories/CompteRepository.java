package com.adria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adria.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

	Optional<Compte> findById(Long id);

	Optional<Compte> findByNumeroCompte(String numeroCompte);



}
