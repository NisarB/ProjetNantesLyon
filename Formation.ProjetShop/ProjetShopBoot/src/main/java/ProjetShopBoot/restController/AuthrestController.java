package ProjetShopBoot.restController;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ProjetShopBoot.entities.Admin;
import ProjetShopBoot.entities.Adresse;
import ProjetShopBoot.entities.Client;
import ProjetShopBoot.entities.Utilisateur;
import ProjetShopBoot.entities.JsonViews;
import ProjetShopBoot.entities.Role;
import ProjetShopBoot.entities.Utilisateur;
import ProjetShopBoot.repositories.AdminRepository;
import ProjetShopBoot.repositories.ClientRepository;
import ProjetShopBoot.repositories.UtilisateurRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthrestController {

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	private final static Logger LOGGER = LoggerFactory.getLogger(AuthrestController.class);

	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public Utilisateur auth(@AuthenticationPrincipal Utilisateur utilisateur) {
		return utilisateur;
	}

	@PostMapping("/inscription")
	@JsonView(JsonViews.Base.class)
	public Client inscriptionClient(@Valid @RequestBody Client utilisateur, BindingResult br) {// @PathVariable string
																								// nom , @PathVariable
																								// string prenom etc...
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		if (utilisateurRepo.findByUsername(utilisateur.getUsername()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		utilisateur.setRole(Role.ROLE_CLIENT);
		if (utilisateur.getAdresse() == null) {
			utilisateur.setAdresse(new Adresse("", "", "", ""));
		}
		return utilisateurRepo.save(utilisateur);

	}

	@GetMapping("/check/{username}")
	@JsonView(JsonViews.Base.class)
	public boolean loginExist(@PathVariable String username) {
		return utilisateurRepo.findByUsername(username).isPresent();
	}

}
