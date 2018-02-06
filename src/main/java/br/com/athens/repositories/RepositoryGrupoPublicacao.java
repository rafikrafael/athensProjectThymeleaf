package br.com.athens.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.athens.domains.GrupoPublicacao;

public interface RepositoryGrupoPublicacao extends CrudRepository<GrupoPublicacao, Long>{
	
	@Query("SELECT a FROM GrupoPublicacao a where a.liberada = true") 	
	 public List<GrupoPublicacao> getGrupoPublicacaoByLiberadas();
}
