#ABONNES
	
	GET:	 http://localhost:8081/VrmntMult/abonnes
	
	GET BY ID:	http://localhost:8081/VrmntMult/abonne?id=
	
	GET BY username:	http://localhost:8081/VrmntMult/abonne/{username}
	
	POST:	http://localhost:8081/VrmntMult/abonne
	
	DELETE:	http://localhost:8081/VrmntMult/abonne/{id}


#BENEFICIAIRES
	
	GET:	http://localhost:8081/VrmntMult/abonne/{id}/beneficiaires
	
	GET BY ID:	http://localhost:8081/VrmntMult/beneficiaire?id=
	
	POST:	http://localhost:8081/VrmntMult/beneficiaire
	
	DELETE:	http://localhost:8081/VrmntMult/beneficiaire/{id}
	
	
#COMPTES
	
	GET (user accounts):	http://localhost:8081/VrmntMult/abonne/{id}/comptes
	
	GET:	http://localhost:8081/VrmntMult/comptes
	
	GET BY ID:	http://localhost:8081/VrmntMult/compte?id=
	
	GET BY numeroCompte:	http://localhost:8081/VrmntMult/compte/{numeroCompte}
	
	POST:	http://localhost:8081/VrmntMult/compte/{id}
	
	DELETE:	http://localhost:8081/VrmntMult/compte/{id}
	
	
#VIREMENTS MULTIPLES

	GET:	http://localhost:8081/VrmntMult/compte/{id}/virementsMultiples
	
	GET BY ID:	http://localhost:8081/VrmntMult/virementMultiple?id=
	
	POST:	http://localhost:8081/VrmntMult/virementMultiple
	
	PUT (CONFIRMER ET SIGNER):	http://localhost:8081/VrmntMult/virementMultiple/{id}/confirmation
	

#VIREMENT MULTIPLE BENEFICIAIRES

	GET:	http://localhost:8081/VrmntMult/virementMultiple/{id}/virementMultipleBeneficiaires
	
	
	