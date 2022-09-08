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
	
//Methode Pour la creation de la table commande et l'insertion dans la base de donnée
	public Commande create(Commande Commande) {
		
		if (Commande.getClient() == null ) {
			throw new CommandeException();
		}
		return commandeRepo.save(Commande);
	}

	//Pour retrouver une commande par son id
	public Commande getById(Long id) {
		return commandeRepo.findById(id).orElseThrow(CommandeException::new);
	
	}
	//Retrouver des effectuées par un seul client
	public List<Commande> getByClient(Client client) {
		return  commandeRepo.findByClient(client);
	
	}
	//Retrouver des commandes faites un jour precis
	public List<Commande> getByDate(LocalDate date) {
		return commandeRepo.findByDate(date);
		
	} 
	//Modification d'une commande
	public Commande update(Commande Commande) {
		Commande CommandeEnBase = getById(Commande.getId());
		CommandeEnBase.setClient(Commande.getClient());
		CommandeEnBase.setFacture(Commande.getFacture());
		CommandeEnBase.setArticles(Commande.getArticles());
		CommandeEnBase.setDate(Commande.getDate());
		return commandeRepo.save(CommandeEnBase);
}
	// Methode pour Lister toutes les commandes effectuées
	public List<Commande> getAll() {
		return commandeRepo.findAll();
	}
	//Methode Pour supprimer une commande en passant par son id
	public void deleteById(Long id) {
		commandeRepo.delete(getById(id));
	}
	//Methode Pour supprimer(reinitialiser) les commandes d'un client 
	public void deleteByClient(Client client) {
		commandeRepo.deleteAll(getByClient(client));
	}
	
}