package projetShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetShop.entities.Article;
import projetShop.entities.Categorie;
import projetShop.exceptions.ArticleException;
import projetShop.repositories.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired 
	ArticleRepository articleRepo;

	
	public Article create(Article article) {
		if (article.getId() == null & article.getNom().isEmpty()) {
			throw new ArticleException();
		}
		return articleRepo.save(article);
	}
	public Article getById(Long id_prod) {
		return articleRepo.findById(id_prod).orElseThrow(ArticleException::new);
	}
	public Article update(Article article) {
        Article articleEnBase = getById(article.getId());
        articleEnBase.setNom(article.getNom());
        articleEnBase.setDescription(article.getDescription());
        articleEnBase.setPrix(article.getPrix());
        articleEnBase.setQuantite(article.getQuantite());
        articleEnBase.setNote(article.getNote());
        articleEnBase.setCategorie(article.getCategorie());
        return articleRepo.save(articleEnBase);
    }
	public List<Article> getAll() {
		return articleRepo.findAll();
	}
		public List<Article> getByCategorie(Categorie categorie) {
			return articleRepo.findByCategorie(categorie);
		}
		public List<Article> getByNom(String nom) {
			return articleRepo.findByNom(nom);
		}
		public List<Article> getByNote(double note) {
			return articleRepo.findByNote(note);
		}
		public List<Article> getByPrix(double prix) {
			return articleRepo.findByNote(prix);
		}
		/*
		public void deleteById(Long id) {
			deleteById((id));
		}
		*/
}
