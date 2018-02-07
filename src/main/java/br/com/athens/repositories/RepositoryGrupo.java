package br.com.athens.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.athens.domains.Grupo;

public interface RepositoryGrupo extends CrudRepository<Grupo, Long>{

	public List<Grupo> findByStatusOrderById(Boolean status);

}
