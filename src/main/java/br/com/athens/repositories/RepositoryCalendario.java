package br.com.athens.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.athens.domains.Calendario;

public interface RepositoryCalendario extends CrudRepository<Calendario, Long>{

	 @Query("SELECT a FROM Calendario a where a.titulo like %?1%") 	
	 public Calendario getCalendarioByTitulo(@Param("titulo") String titulo);
}
