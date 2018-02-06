package br.com.athens.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.athens.domains.Usuario;
import br.com.athens.repositories.RepositoryUsuario;

@Service
@Transactional
public class ServiceUsuario extends AbstractService<Usuario> implements UserDetailsService {

	private RepositoryUsuario repository;

	@Autowired
	public ServiceUsuario(RepositoryUsuario repository) {
		super();
		this.repository = repository;
	}

	@Override
	public CrudRepository<Usuario, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Usuario save(Usuario entity) {
		if (entity.getRole() == null || entity.getRole().isEmpty()) {
			entity.setRole("ROLE_USER");			
		}
		System.out.println("senhaaa " + entity.getSenha());
		System.out.println("senhaaa " + entity.getPlainPassword());
		return super.save(entity);
	}

	public Usuario getUsuarioByEmail(String email) {
		return this.repository.getUsuaryByEmail(email);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		if (email.isEmpty()) {
			System.out.println("E-mail em branco");
			throw new UsernameNotFoundException("E-mail em branco");
		}

		System.out.println("Vai buscar o usuário");
		Usuario usuario = repository.getUsuaryByEmail(email);

		if (usuario == null) {
			System.out.println("Usuário não encontrado " + email);
			throw new UsernameNotFoundException("Usuário não encontrado");
		}

		String role = (usuario.getRole() != null ? usuario.getRole() : "ROLE_USER");

		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
		String password = usuario.getSenha();
		System.out.println("password -> " + password);
		return new User(email, password, auth);
	}

}
