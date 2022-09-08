package ProjetShopBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.Commande;
import ProjetShopBoot.entities.ListeArticle;
import ProjetShopBoot.entities.ListeArticleKey;
import ProjetShopBoot.exceptions.ListeArticleException;
import ProjetShopBoot.repositories.ListeArticleRepository;

@Service
public class ListeArticleService {
	
	@Autowired
	private ListeArticleRepository listeArticleRepo;
	
	public ListeArticle create(ListeArticle listeArticle) {
		if (listeArticle.getId().getArticle() == null || listeArticle.getId().getCommande() == null ||
				listeArticle.getQuantite() == 0) {
			throw new ListeArticleException();
		}
		return listeArticleRepo.save(listeArticle);
	}
	
	public ListeArticle create(Commande commande,Article article,int quantite) {
		if(commande == null || article == null || quantite == 0) {
			throw new ListeArticleException();
		}
		ListeArticle la = new ListeArticle();
		ListeArticleKey lak = new ListeArticleKey();
		la.setQuantite(quantite);
		lak.setArticle(article);
		lak.setCommande(commande);
		la.setId(lak);
		
		return listeArticleRepo.save(la);
	}
	
	public void delete(ListeArticle listeArticle) {
		listeArticleRepo.delete(listeArticle);
	}
	
	public List<ListeArticle> getAll(){
		return listeArticleRepo.findAll();
	}


}
