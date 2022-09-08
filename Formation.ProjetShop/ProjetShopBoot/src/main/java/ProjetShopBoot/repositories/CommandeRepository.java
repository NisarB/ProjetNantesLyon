package ProjetShopBoot.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ProjetShopBoot.entities.Client;
import ProjetShopBoot.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	List<Commande> findByClient(Client client);

	List<Commande> findByDate(LocalDate date);

	Optional<Commande> findById(@Param("id") Long id);

	void deleteById(Long id);

	void deleteByClient(Client client);

	@Transactional
	@Modifying
	@Query("update Commande c set c.client=null where c.client=:client")
	void setClientToNullByClient(@Param("client") Client client);

}
