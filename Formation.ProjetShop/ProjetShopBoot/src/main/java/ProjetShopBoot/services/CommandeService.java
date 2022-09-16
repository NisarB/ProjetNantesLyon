package ProjetShopBoot.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetShopBoot.entities.Client;
import ProjetShopBoot.entities.Commande;
import ProjetShopBoot.exceptions.CommandeException;
import ProjetShopBoot.repositories.ClientRepository;
import ProjetShopBoot.repositories.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepo;

	@Autowired
	ClientRepository clientRepo;

	public Commande create(Commande Commande) {

		if (Commande.getClient() == null) {
			throw new CommandeException();
		}
		return commandeRepo.save(Commande);
	}

	public Commande getById(Long id) {
		return commandeRepo.findById(id).orElseThrow(CommandeException::new);

	}

	public List<Commande> getByClient(Client client) {
		return commandeRepo.findByClient(client);

	}

	public List<Commande> getByDate(LocalDate date) {
		return commandeRepo.findByDate(date);

	}

	public Commande update(Commande Commande) {
		Commande CommandeEnBase = getById(Commande.getId());
		CommandeEnBase.setClient(Commande.getClient());
		CommandeEnBase.setFacture(Commande.getFacture());
		CommandeEnBase.setArticles(Commande.getArticles());
		CommandeEnBase.setDate(Commande.getDate());
		return commandeRepo.save(CommandeEnBase);
	}

	public List<Commande> getAll() {
		return commandeRepo.findAll();
	}

	public void deleteById(Long id) {
		commandeRepo.delete(getById(id));
	}

	public void deleteByClient(Client client) {
		commandeRepo.deleteAll(getByClient(client));
	}

}