package projetShop;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import projetShop.entities.Article;
import projetShop.entities.Avis;
import projetShop.entities.AvisKey;
import projetShop.entities.Categorie;
import projetShop.entities.Client;
import projetShop.entities.Commande;
import projetShop.entities.Facture;
import projetShop.entities.ListeArticle;
import projetShop.entities.ListeArticleKey;
import projetShop.services.ArticleService;
import projetShop.services.AvisService;
import projetShop.services.ClientService;
import projetShop.services.CommandeService;
import projetShop.services.ListeArticleService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { projetShop.config.AppConfig.class })

public class TestService {

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private AvisService avisService;
	@Autowired
	private ListeArticleService listeArticleService;


	@Test
	public void creationCommandeTest() {

		// Creation de client du à la valeur true de nullable (attributs user & password
		// =>classe utilisateur)

		Client client = new Client();
		client.setPrenom("olivier");
		client.setNom("gozlan");
		client.setUsername("aaahha");
		client.setPassword("aaajja");
		Client client1 = new Client();
		client1.setPrenom("Haza");
		client1.setNom("ban");
		client1.setUsername("aafevbuoa");
		client1.setPassword("aasdiza");
		Client client2 = new Client();
		client2.setPrenom("yami");
		client2.setNom("ban");
		client2.setUsername("azqwhha");
		client2.setPassword("aaampoljja");
		
		
		Article article = new Article("article1", 19.99, Categorie.C1);
		articleService.create(article);

		// Insertion dans la base de données
		
		clientService.create(client);
		clientService.create(client1);
		clientService.create(client2);
		
		AvisKey aviskey = new AvisKey(client1,article);
		Avis avis = new Avis(aviskey, "BOF BOF",3.0);
		avisService.create(avis);
		
		Commande commande = new Commande();
		commande.setClient(client2);
		commande.setDate(LocalDate.now());
		commande.setFacture(new Facture());
		
		ListeArticle la = new ListeArticle(new ListeArticleKey(commande, article),1);
		Set<ListeArticle> mySet = new HashSet<ListeArticle>();
		mySet.add(la);
		
		commande.setArticles(mySet);
		
		commandeService.create(commande);
		listeArticleService.create(la);
		
		Commande commande1 = new Commande();
		commande1.setClient(client1);
		commande1.setDate(LocalDate.now());
		commande1.setFacture(new Facture());
		
		ListeArticle la1 = new ListeArticle(new ListeArticleKey(commande1, article),1);
		mySet.clear();
		mySet.add(la1);
		commande.setArticles(mySet);
		
		commandeService.create(commande1);
		listeArticleService.create(la1);
		
		
		
		

//		// Lister toutes les commandes effectuées
//
//		System.out.println(commandeService.getAll());
//
//		// Retrouver les commandes faites par un seul client (client olivier)
//
//		System.out.println(commandeService.getByClient(client).get(0));
//
//		// Retrouver un client à partir de son id de commande
//
//		System.out.println(commandeService.getById(100L).getClient().getNom());
//
//		// Retrouver des commandes à partir de la date
//
//		System.out.println(commandeService.getByDate(LocalDate.now()));
//
//		// Supression des commandes du client olivier (commande et commande 2)
//
//		// commandeService.deleteByClient(client);
//		 

	}
}
