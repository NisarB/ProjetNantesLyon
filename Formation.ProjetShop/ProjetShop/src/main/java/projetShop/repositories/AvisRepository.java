package projetShop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetShop.entities.Article;
import projetShop.entities.Avis;
import projetShop.entities.AvisKey;
import projetShop.entities.Client;

public interface AvisRepository extends JpaRepository<Avis,AvisKey>{
	
//	@Query("SELECT Avis a WHERE a.notes >=:note")
//	List<Avis> findAvisByNote(@Param("note")double note);
//	
//	@Query("SELECT Avis a WHERE a.id.article =:article")
//	List<Avis> findAvisByArticle(@Param("article") Article article);
//	
//	@Query("SELECT Avis a WHERE a.avis LIKE %:text% ")
//	List<Avis> findAvisByString(@Param("text") String text);
//	
//	@Query("SELECT Avis a WHERE a.id.client =:client")
//	List<Avis> findAvisByClient(@Param("client") Client client);
//	
	
	List<Avis> findAvisByNote(double note);
	
	List<Avis> findByIdClient(Client client);
	List<Avis> findByIdArticle(Article article);
	
	
	//List<Avis> findAvisByArticle(Article article);
	
	
	//List<Avis> findAvisByClient(Client client);
	
}
