package br.com.athens.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.athens.domains.Calendario;
import br.com.athens.domains.Notificacao;

public interface RepositoryNotificacao extends CrudRepository<Notificacao, Long>{

	@Query("SELECT a FROM Notificacao a where a.descricao like %?1%") 	
	 public Calendario getNotificacaoByDescricao(@Param("descricao") String titulo);
}
