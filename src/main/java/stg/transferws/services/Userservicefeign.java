package stg.transferws.services;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import stg.transferws.dto.UserDto;
        import stg.transferws.repositories.UserRepository;

import stg.transferws.entities.user;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
        import java.util.Optional;
@Service
public class Userservicefeign {

    @Autowired
    private UserRepository userRepository;
   /* @PostConstruct
    public void initializeData() {
        user user1 = new user();
        user1.setRib("123456");
        user1.setUsername("Alice");
        user1.setSolde(500.00);

        user user2 = new user();
        user2.setRib("789012");
        user2.setUsername("Bob");
        user2.setSolde(700.00);

        user user3 = new user();
        user3.setRib("345678");
        user3.setUsername("Charlie");
        user3.setSolde(300.00);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }*/
//    public user loadUser(String rib) {
//        return userRepository.findByRib(rib);
//    }
    public Optional<UserDto> loadUser(String rib) {
        user user = userRepository.findByRib(rib);
        if (user != null) {
            UserDto userDto = convertUserToDto(user);
            return Optional.of(userDto);
        } else {
            return Optional.empty();
        }
    }
    public String updateSolde(UserDto userDto) {
        user user = userRepository.findByRib(userDto.getRib());

        if (user != null) {
            user.setSolde(userDto.getSolde());
            userRepository.save(user); // Mettre à jour le solde dans la base de données
            return "Solde mis à jour pour " + userDto.getRib();
        } else {
            return "Utilisateur introuvable";
        }
    }
    public String ajouterSolde(UserDto userDto) {
        user user = userRepository.findByRib(userDto.getRib());

        if (user != null) {
            double soldeActuel = user.getSolde();
            double nouveauSolde = soldeActuel + userDto.getSolde(); // Calcul du nouveau solde
            user.setSolde(nouveauSolde);
            userRepository.save(user); // Mise à jour du solde dans la base de données
            return "Versement effectué pour " + userDto.getRib() + " de " + userDto.getSolde();
        } else {
            return "Utilisateur introuvable";
        }
    }

    private UserDto convertUserToDto(user user) {
        UserDto userDto = new UserDto();
        // Copier les données de l'entité user vers l'objet UserDto
        userDto.setRib(user.getRib());
        userDto.setUsername(user.getUsername());
        userDto.setSolde(user.getSolde());
        // Autres attributs...

        return userDto;
    }

    public List<user> loadUsers() {
        Iterable<user> usersIterable = userRepository.findAll();
        List<user> usersList = new ArrayList<>();
        usersIterable.forEach(usersList::add);
        return usersList;
    }
    public String retirerSolde(String rib, double montant) {
        user user = userRepository.findByRib(rib);
        if (user != null) {
            double solde = user.getSolde();
            if (solde >= montant) {
                double nouveauSolde = solde - montant; // Calcul du nouveau solde
                user.setSolde(nouveauSolde); // Mise à jour du solde de l'utilisateur
                userRepository.save(user); // Enregistrement du nouvel état du User
                return "Retrait effectué pour " + rib + " de " + montant;
            } else {
                return "Solde insuffisant pour le retrait";
            }
        } else {
            return "Utilisateur introuvable";
        }
    }



}

