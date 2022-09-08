package ProjetShopBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.Avis;
import ProjetShopBoot.entities.AvisKey;
import ProjetShopBoot.entities.Client;
import ProjetShopBoot.exceptions.AvisException;
import ProjetShopBoot.repositories.ArticleRepository;
import ProjetShopBoot.repositories.AvisRepository;

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
	
	public Avis create(Avis avis,Client client,Article article) {
		if (avis.getAvis() == null || avis.getAvis().isEmpty() || article == null ||
				client == null ) {
			throw new AvisException();
		}
		AvisKey avisId = new AvisKey(client, article);
		avis.setId(avisId);
		return avisRepo.save(avis);
	}
	
	public Avis create(String avisString,double note,Client client,Article article) {
		if (avisString == null || avisString.isEmpty() || article == null ||
				client == null) {
			throw new AvisException();
		}
		Avis avis = new Avis();
		AvisKey avisId = new AvisKey(client, article);
		avis.setAvis(avisString);
		avis.setNote(note);
		avis.setId(avisId);
		return avisRepo.save(avis);
	}
	
	public void delete(Avis avis) {
		avisRepo.delete(avis);
	}

	public List<Avis> getAll() {
		return avisRepo.findAll();
	}
	
}
	