package projetShop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetShop.entities.Article;
import projetShop.entities.Commande;
import projetShop.entities.ListeArticle;
import projetShop.entities.ListeArticleKey;


public interface ListeArticleRepository extends JpaRepository<ListeArticle,ListeArticleKey>{
	
	List<ListeArticle> findByIdCommande(Commande commande);
	List<ListeArticle> findByIdArticle(Article article);
}
