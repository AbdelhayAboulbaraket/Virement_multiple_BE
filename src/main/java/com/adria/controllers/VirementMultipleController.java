package com.adria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adria.entities.VirementMultiple;
import com.adria.entities.VirementMultipleBeneficiaire;
import com.adria.services.VirementMultipleService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class VirementMultipleController {
	
	
	@Autowired
	VirementMultipleService virementMultipleService;
	
	
	@GetMapping("/virementMultiple")
	@ResponseStatus(HttpStatus.OK)
	public VirementMultiple getVirementMultiple(@RequestParam(value="id") Long id)
	{
		return virementMultipleService.getVirementMultiple(id);
	}
	
	
	
	@PostMapping("/virementMultiple")
	@ResponseStatus(HttpStatus.CREATED)
	public void EffectuerVirementMultiple(@RequestBody VirementMultiple virementMultiple)
	{
		virementMultipleService.EffectuerVirementMultiple(virementMultiple);
	}
	
	@GetMapping("/virementMultiple/{id}/virementMultipleBeneficiaires")
	@ResponseStatus(HttpStatus.OK)
	public List<VirementMultipleBeneficiaire> virementMultipleBeneficiaires(@PathVariable(value="id") Long id)
	{
		return virementMultipleService.getVirementMultipleBeneficiaires(id);
	}
	
	
	
	@PutMapping("/virementMultiple/{id}/confirmation")
	@ResponseStatus(HttpStatus.OK)
	public void confirmerEtSigner(@PathVariable(value="id") Long id, @RequestBody String password)
	{
		virementMultipleService.confirmerEtSigner(id, password);
	}

}
