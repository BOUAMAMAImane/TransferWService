package stg.transferws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequestDTO {
    private String emetteur;
    private String destinataire;
    private String operation_type;
    private double montant;
}
