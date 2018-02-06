package br.com.athens.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.athens.domains.Notificacao;
import br.com.athens.repositories.RepositoryNotificacao;

@Service
@Transactional
public class ServiceNotificacao extends AbstractService<Notificacao>{

	private RepositoryNotificacao repository;
	
	@Override
	public CrudRepository<Notificacao, Long> getRepository() {
		return this.repository;
	}

	@Autowired
	public ServiceNotificacao(RepositoryNotificacao repository) {
		this.repository = repository;
	}
}
