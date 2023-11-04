package stg.transferws.feign;


import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import stg.transferws.dto.UserDto;

@FeignClient(name = "attijari", url = "http://3.217.215.70:8081/attijari", path = "/registration")
public interface UserAttijariFeign {

	 @GetMapping("/userByRib")
	 Optional<UserDto> loadUser(@RequestParam String rib);
	 
	 @GetMapping("/allUsers")
     List<UserDto> loadUsers();
	 
	 @PutMapping("/retierSolde")
	 String retirerSolde(@RequestParam String rib,@RequestParam double montant);
}
