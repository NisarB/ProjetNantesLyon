package ProjetShopBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import ProjetShopBoot.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	List<Admin> findByUsername(String Username);
	List<Admin> findArticleById(@Param("article") Long id);
	
}
