package ProjetShopBoot.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.Avis;
import ProjetShopBoot.entities.AvisKey;
import ProjetShopBoot.entities.Client;

public interface AvisRepository extends JpaRepository<Avis, AvisKey> {

	List<Avis> findAvisByNote(double note);

	Optional<Avis> findById(AvisKey avisKey);

	List<Avis> findByIdClient(Client client);

	List<Avis> findByIdArticle(Article article);

	@Transactional
	void deleteByIdArticle(Article article);

	@Transactional
	void deleteByIdClient(Client client);

	@Transactional
	@Modifying
	@Query("update Avis a set a.id.article=null where a.id.article=:article")
	void setArticleToNullByArticle(@Param("article") Article article);

	@Transactional
	@Modifying
	@Query("update Avis a set a.id.client=null where a.id.client=:client")
	void SetAvisClientToNullByClient(@Param("client") Client client);

}
