package ProjetShopBoot.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetShopBoot.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	Optional<Utilisateur> findByUsername(String Username);

}
