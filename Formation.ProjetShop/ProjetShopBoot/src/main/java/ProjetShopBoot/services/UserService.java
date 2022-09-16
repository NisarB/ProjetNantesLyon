package ProjetShopBoot.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ProjetShopBoot.repositories.AdminRepository;
import ProjetShopBoot.repositories.ClientRepository;
import ProjetShopBoot.repositories.UtilisateurRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return utilisateurRepo.findByUsername(username).orElseThrow(() -> {
			throw new UsernameNotFoundException("Utilisateur Inconnu");
		});
	}

}
