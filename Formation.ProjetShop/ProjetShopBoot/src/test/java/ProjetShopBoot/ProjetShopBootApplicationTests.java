package ProjetShopBoot;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import ProjetShopBoot.entities.Admin;
import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.Categorie;
import ProjetShopBoot.entities.Client;
import ProjetShopBoot.entities.Commande;
import ProjetShopBoot.entities.Facture;
import ProjetShopBoot.entities.ListeArticle;
import ProjetShopBoot.entities.Role;
import ProjetShopBoot.entities.Utilisateur;
import ProjetShopBoot.repositories.AdminRepository;
import ProjetShopBoot.repositories.ArticleRepository;
import ProjetShopBoot.repositories.ClientRepository;
import ProjetShopBoot.repositories.CommandeRepository;
import ProjetShopBoot.repositories.UtilisateurRepository;

@SpringBootTest
class ProjetShopBootApplicationTests {

	@Autowired
	public AdminRepository adminRepo;
	@Autowired
	private PasswordEncoder passwordencoder;
	@Autowired
	private CommandeRepository commandeRepo;
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private ArticleRepository articleRepo;

	@Test
	void contextLoads() {
		Admin admin = new Admin();
		admin.setPassword(passwordencoder.encode("Admin0@"));
		admin.setUsername("admin");
		admin.setRole(Role.ROLE_ADMIN);
		adminRepo.save(admin);
	}

}
