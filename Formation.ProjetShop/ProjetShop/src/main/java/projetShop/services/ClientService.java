package projetShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetShop.entities.Client;
import projetShop.exceptions.ClientException;
import projetShop.exceptions.CommandeException;
import projetShop.repositories.ClientRepository;
import projetShop.repositories.CommandeRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private CommandeRepository commandeRepo;

	public Client create(Client client) {
		if (client.getPrenom() == null || client.getPrenom().isEmpty()) {
			throw new ClientException();
		}
		if (client.getNom() == null || client.getNom().isEmpty()) {
			throw new ClientException();
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
		Client clientEnBase = getById(client.getId());
		clientEnBase.setPrenom(client.getPrenom());
		clientEnBase.setNom(client.getNom());
		clientEnBase.setAdresse(client.getAdresse());
		clientEnBase.setMail(client.getMail());
		return clientRepo.save(clientEnBase);
	}
	

	public List<Client> getAll() {
		return clientRepo.findAll();
	}

	public void delete(Client client) {
		commandeRepo.setClientToNullByClient(client);
		clientRepo.delete(client);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

}