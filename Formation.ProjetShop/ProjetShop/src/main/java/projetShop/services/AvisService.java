package projetShop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetShop.entities.Avis;
import projetShop.exceptions.AvisException;
import projetShop.repositories.ArticleRepository;
import projetShop.repositories.AvisRepository;

@Service
public class AvisService {
	@Autowired
	private AvisRepository avisRepo;
	
	@Autowired
	private ArticleRepository articleRepo;

	public Avis create(Avis avis) {
		if (avis.getAvis() == null || avis.getId().getArticle() == null ||
				avis.getId().getClient() == null ||avis.getAvis().isEmpty()) {
			throw new AvisException();
		}
		return avisRepo.save(avis);
	}
	
	
}
	