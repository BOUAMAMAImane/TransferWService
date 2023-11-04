package stg.transferws.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stg.transferws.dto.UserDto;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Virement {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateVirement;
	private String emetteur;
	private String destinataire;
	private double montant;
}
