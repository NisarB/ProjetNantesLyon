package projetShop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetShop.entities.ListeArticle;
import projetShop.exceptions.ListeArticleException;
import projetShop.repositories.ListeArticleRepository;

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
	

}
