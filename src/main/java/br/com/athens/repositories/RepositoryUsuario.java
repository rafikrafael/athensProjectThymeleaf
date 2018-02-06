package br.com.athens.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.athens.domains.Usuario;

public interface RepositoryUsuario extends CrudRepository<Usuario, Long> {
	
	public Usuario getUsuarioByNome(String nome);
	
	public Usuario getUsuaryByEmail(String email);
	
}
