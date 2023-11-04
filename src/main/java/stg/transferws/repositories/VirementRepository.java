package stg.transferws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stg.transferws.entities.Virement;
@Repository
public interface VirementRepository extends JpaRepository<Virement,Long>{

}
