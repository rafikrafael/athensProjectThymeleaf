package br.com.athens.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.athens.domains.GrupoPublicacao;
import br.com.athens.repositories.RepositoryGrupoPublicacao;

@Service
@Transactional
public class ServiceGrupoPublicacao extends AbstractService<GrupoPublicacao>{

	private RepositoryGrupoPublicacao repository;
	
	@Override
	public CrudRepository<GrupoPublicacao, Long> getRepository() {
		return this.repository;
	}
	
	@Autowired
	public ServiceGrupoPublicacao(RepositoryGrupoPublicacao repository) {
		this.repository = repository;
	}

}
