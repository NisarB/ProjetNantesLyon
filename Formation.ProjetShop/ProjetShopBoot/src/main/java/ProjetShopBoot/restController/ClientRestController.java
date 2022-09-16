package ProjetShopBoot.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetShopBoot.entities.Client;
import ProjetShopBoot.entities.JsonViews;
import ProjetShopBoot.exceptions.ClientException;
import ProjetShopBoot.services.ClientService;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientRestController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Client getById(@PathVariable Long id) {
		return clientService.getById(id);
	}

	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Client> getAll() {
		return clientService.getAll();
	}

	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return clientService.create(client);
	}

	@PostMapping("/{id}")
	public Client getByIdWithCommandes(@PathVariable Long id) {
		return clientService.getByIdWithCommandes(id);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Client update(@Valid @RequestBody Client client, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		client.setId(id);
		return clientService.update(client);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		clientService.deleteById(id);
	}
}
