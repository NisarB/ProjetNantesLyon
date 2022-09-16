package ProjetShopBoot.restController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.Avis;
import ProjetShopBoot.entities.AvisKey;
import ProjetShopBoot.entities.Client;
import ProjetShopBoot.entities.JsonViews;
import ProjetShopBoot.model.AvisRestModel;
import ProjetShopBoot.services.AvisService;

@RestController
@RequestMapping("/api/avis")
@CrossOrigin(origins = "*")
public class AvisRestController {

	@Autowired
	private AvisService avisService;

	@GetMapping("")
	@JsonView(JsonViews.Avis.class)
	public List<Avis> getAvis() {
		return avisService.getAll();
	}

	@GetMapping("/{aid}")
	@JsonView(JsonViews.Avis.class)
	public List<Avis> getAvisArticle(@PathVariable long aid) {
		Article article = new Article();
		article.setId(aid);
		return avisService.getByIdArticle(article);
	}

	@PostMapping("")
	@JsonView(JsonViews.Avis.class)
	public Avis create(@Valid @RequestBody Avis avis, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return avisService.create(avis);
	}

	@PutMapping("")
	@JsonView(JsonViews.Avis.class)
	public Avis update(@Valid @RequestBody Avis avis, BindingResult br) {

		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Client client = new Client();
		client.setId(avis.getId().getClient().getId());
		Article article = new Article();
		article.setId(avis.getId().getArticle().getId());

		avis.setId(new AvisKey(client, article));
		return avisService.update(avis);
	}

	@GetMapping("/article/{aid}/client/{cid}")
	@JsonView(JsonViews.Avis.class)
	public Avis findClientAvis(@PathVariable long aid, @PathVariable long cid) {
		Client client = new Client();
		client.setId(cid);
		Article article = new Article();
		article.setId(aid);
		return avisService.getById(new AvisKey(client, article));
	}

}
