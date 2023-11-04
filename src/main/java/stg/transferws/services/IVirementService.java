package stg.transferws.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import stg.transferws.dto.UserDto;
import stg.transferws.entities.Virement;

public interface IVirementService {
	Virement addVirement(Virement virement );
	ResponseEntity<Object> findAllUsers();

	UserDto consulteUserAccount(String rib) throws Exception;
//	ResponseEntity<Object> findAllUsers();
	void retirer(String rib, double montant) throws Exception;
	void verser(String rib, double montant) throws Exception;
	void virement(String emetteur, String destinataire, double montant) throws Exception;
	}
