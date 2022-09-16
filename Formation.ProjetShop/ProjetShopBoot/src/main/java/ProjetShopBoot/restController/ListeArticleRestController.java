package ProjetShopBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetShopBoot.entities.JsonViews;
import ProjetShopBoot.entities.ListeArticle;
import ProjetShopBoot.model.ListeArticleRestModel;
import ProjetShopBoot.services.ListeArticleService;

@RestController
@RequestMapping("/api/liste-article")
@CrossOrigin(origins = "*")
public class ListeArticleRestController {

	@Autowired
	private ListeArticleService laService;

	@GetMapping("")
	@JsonView(JsonViews.ListeArticle.class)
	public List<ListeArticle> getListeArticle() {
		return laService.getAll();
	}

	@PostMapping("")
	@JsonView(JsonViews.ListeArticle.class)
	public ListeArticle create(@RequestBody ListeArticleRestModel listeArticleModel) {
		return laService.create(listeArticleModel.getCommande(), listeArticleModel.getArticle(),
				listeArticleModel.getQuantite());
	}

}
