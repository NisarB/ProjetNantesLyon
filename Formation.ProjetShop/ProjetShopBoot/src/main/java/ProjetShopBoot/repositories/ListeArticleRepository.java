package ProjetShopBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.Commande;
import ProjetShopBoot.entities.ListeArticle;
import ProjetShopBoot.entities.ListeArticleKey;


public interface ListeArticleRepository extends JpaRepository<ListeArticle,ListeArticleKey>{
	
	List<ListeArticle> findByIdCommande(Commande commande);
	List<ListeArticle> findByIdArticle(Article article);
}
