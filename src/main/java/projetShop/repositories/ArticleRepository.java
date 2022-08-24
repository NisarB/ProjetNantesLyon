package projetShop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import projetShop.entities.Article;
import projetShop.entities.Categorie;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByNom(String nom);
	List<Article> findByNote(double note);
	List<Article> findByCategorie(Categorie categorie);
	Optional<Article>findById(@Param("id") Long id);
	void deleteById( Long id);

	
	

}
