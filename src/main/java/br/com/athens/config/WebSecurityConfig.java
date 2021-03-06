/**
 * 
 */
package br.com.athens.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.athens.services.ServiceUsuario;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired 
	ServiceUsuario serviceUsuario;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/registrar").permitAll()
				.antMatchers("/", "/webjars/**").authenticated()
				.antMatchers("/js/*","/css/*","/img/*").permitAll()
				.antMatchers("/incluir*", "/listar*").authenticated()
				.antMatchers("/admin").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(serviceUsuario).passwordEncoder(passwordEncoder);
	}
	
	
}
