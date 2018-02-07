package br.com.athens.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.athens.domains.Grupo;
import br.com.athens.repositories.RepositoryGrupo;

@Service
@Transactional
public class ServiceGrupo extends AbstractService<Grupo>{

private RepositoryGrupo repository;
	
	@Autowired
	public ServiceGrupo(RepositoryGrupo repository) {
		this.repository = repository;
	}
	@Override
	public CrudRepository<Grupo, Long> getRepository() {	
		return this.repository;
	}
	
	public List<Grupo> getAllNotDelete() {
		return this.repository.findByStatusOrderById(false);
	}

}
