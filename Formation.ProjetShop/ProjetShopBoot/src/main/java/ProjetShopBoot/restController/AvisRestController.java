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

import ProjetShopBoot.entities.Avis;
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
	
	@PostMapping("")
	@JsonView(JsonViews.Avis.class)
	public Avis create(@RequestBody AvisRestModel avisModel) {
		
		return avisService.create(avisModel.getAvis(), avisModel.getNote(), 
									avisModel.getClient(), avisModel.getArticle());
	}
}
