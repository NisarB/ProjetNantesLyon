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
import ProjetShopBoot.entities.Categorie;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	List<Article> findByNom(String nom);

	List<Article> findByNote(double note);

	List<Article> findByCategorie(Categorie categorie);

	Optional<Article> findById(@Param("id") Long id);

	void deleteById(Long id);
}
