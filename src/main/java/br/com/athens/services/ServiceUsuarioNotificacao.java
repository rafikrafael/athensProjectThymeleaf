package br.com.athens.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import br.com.athens.domains.UsuarioNotificacao;
import br.com.athens.repositories.RepositoryUsuarioNotificacao;

public class ServiceUsuarioNotificacao extends AbstractService<UsuarioNotificacao> {

	private RepositoryUsuarioNotificacao repository;
	
	@Autowired
	public ServiceUsuarioNotificacao(RepositoryUsuarioNotificacao repository) {
		super();
		this.repository = repository;
	}

	@Override
	public CrudRepository<UsuarioNotificacao, Long> getRepository() {
		return this.repository;
	}

}
