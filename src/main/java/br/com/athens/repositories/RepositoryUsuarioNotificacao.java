package br.com.athens.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.athens.domains.Usuario;
import br.com.athens.domains.UsuarioNotificacao;

public interface RepositoryUsuarioNotificacao extends CrudRepository<UsuarioNotificacao, Long> {
	
	public UsuarioNotificacao getUsuarioNotificacaoByUsuario(Usuario usuario);

}
