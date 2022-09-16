package ProjetShopBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetShopBoot.entities.Client;
import ProjetShopBoot.entities.Commande;
import ProjetShopBoot.entities.JsonViews;
import ProjetShopBoot.services.CommandeService;

@RestController
@RequestMapping("/api/commande")
@CrossOrigin(origins = "*")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeService;

	@GetMapping("")
	@JsonView(JsonViews.Commande.class)
	public List<Commande> getAll() {
		return commandeService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Commande.class)
	public Commande getById(@PathVariable Long id) {
		return commandeService.getById(id);
	}

	@GetMapping("/client/{id}")
	@JsonView(JsonViews.Commande.class)
	public List<Commande> getByClientId(@PathVariable Long id) {
		Client client = new Client();
		client.setId(id);
		return commandeService.getByClient(client);
	}

	@PostMapping("")
	@JsonView(JsonViews.Commande.class)
	public Commande create(@RequestBody Commande commande) {
		return commandeService.create(commande);
	}

	@DeleteMapping("/{id}")
	@JsonView(JsonViews.Commande.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		commandeService.deleteById(id);
	}
}