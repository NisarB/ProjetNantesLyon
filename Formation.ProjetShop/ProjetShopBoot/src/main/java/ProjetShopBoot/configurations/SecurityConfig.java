package ProjetShopBoot.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ProjetShopBoot.services.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		
		http.antMatcher("/api/**")
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.OPTIONS).anonymous()
					.antMatchers("/api/article").permitAll()
					.antMatchers(HttpMethod.PUT,"/api/avis").permitAll()
					.antMatchers(HttpMethod.OPTIONS).anonymous()
					.antMatchers("/api/admin").permitAll()
					.antMatchers("/api/client/**").permitAll()
					.antMatchers("/api/commande").permitAll()
					.antMatchers(HttpMethod.POST,"/api/auth/inscription/**").anonymous()
					.antMatchers(HttpMethod.GET,"/api/auth/check/**").anonymous()
					.antMatchers("/api/**").permitAll()
				.and()
				.httpBasic();
	}

	
	@Autowired
	private UserService userDetailsService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
	}
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
