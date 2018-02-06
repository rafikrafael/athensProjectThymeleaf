package br.com.athens.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.athens.domains.Calendario;
import br.com.athens.repositories.RepositoryCalendario;

@Service
@Transactional
public class ServiceCalendario extends AbstractService<Calendario>{

	private RepositoryCalendario repository;
	
	@Autowired
	public ServiceCalendario(RepositoryCalendario repository) {
		this.repository = repository;
	}
	@Override
	public CrudRepository<Calendario, Long> getRepository() {	
		return this.repository;
	}

}
