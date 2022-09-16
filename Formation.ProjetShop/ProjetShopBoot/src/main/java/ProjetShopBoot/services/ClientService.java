package ProjetShopBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetShopBoot.entities.Adresse;
import ProjetShopBoot.entities.Client;
import ProjetShopBoot.exceptions.ClientException;
import ProjetShopBoot.exceptions.CommandeException;
import ProjetShopBoot.repositories.AvisRepository;
import ProjetShopBoot.repositories.ClientRepository;
import ProjetShopBoot.repositories.CommandeRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private AvisRepository avisRepo;
	@Autowired
	private CommandeRepository commandeRepo;

	public Client create(Client client) {
		if (client.getPrenom() == null || client.getPrenom().isEmpty()) {
			throw new ClientException();
		}
		if (client.getNom() == null || client.getNom().isEmpty()) {
			throw new ClientException();
		}
		if (client.getAdresse().getVille() == null) {
			client.setAdresse(new Adresse("Numero de Rue", "Rue", "Code Postal", "Ville"));
		}
		return clientRepo.save(client);
	}

	public Client create(String prenom, String nom) {
		Client client = new Client();
		client.setPrenom(prenom);
		client.setNom(nom);
		return create(client);
	}

	public Client getById(Long id) {
		return clientRepo.findById(id).orElseThrow(CommandeException::new);
	}

	public List<Client> getByNom(String nom) {
		return clientRepo.findByNom(nom);
	}

	public Client update(Client client) {
		if (client.getAdresse() == null) {
			client.setAdresse(new Adresse("", "", "", ""));
		}
		Client clientEnBase = getById(client.getId());
		clientEnBase.setPrenom(client.getPrenom());
		clientEnBase.setNom(client.getNom());
		clientEnBase.setTel(client.getTel());
		clientEnBase.setAdresse(client.getAdresse());
		clientEnBase.setMail(client.getMail());
		return clientRepo.save(clientEnBase);
	}

	public List<Client> getAll() {
		return clientRepo.findAll();
	}

	public void delete(Client client) {

		avisRepo.deleteByIdClient(client);
		commandeRepo.setClientToNullByClient(client);
		clientRepo.delete(client);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

	public Client getByIdWithCommandes(Long id) {
		return clientRepo.findByKeyWithCommandes(id).orElseThrow(() -> {
			throw new ClientException();
		});
	}

}