package stg.transferws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stg.transferws.dto.UserDto;
import stg.transferws.entities.user;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<user, Long> {
    user findByRib(String rib);
}