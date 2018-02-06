package br.com.athens.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.athens.domains.Publicacao;
import br.com.athens.domains.Usuario;

public interface RepositoryPublicacao extends CrudRepository<Publicacao, Long> {

	@Query("SELECT a FROM Publicacao a where a.titulo like %?1%")
	public List<Publicacao> getPublicacaoByTitulo(@Param("titulo") String titulo);

	public List<Publicacao> findByUsuarioAndStatusOrderByIdDesc(Usuario usuario, Boolean statusExcluido);
	
	@Query(value = "SELECT * FROM Publicacao order by id_publicacao desc limit 10", nativeQuery = true)
	public List<Publicacao> getAllLast10();
}
