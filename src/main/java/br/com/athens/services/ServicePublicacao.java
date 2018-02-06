package br.com.athens.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.athens.domains.Publicacao;
import br.com.athens.domains.Usuario;
import br.com.athens.repositories.RepositoryPublicacao;

@Service
@Transactional
public class ServicePublicacao extends AbstractService<Publicacao>{

	private RepositoryPublicacao repository;
	
	@Override
	public CrudRepository<Publicacao, Long> getRepository() {
		return this.repository;
	}

	@Autowired
	public ServicePublicacao(RepositoryPublicacao repository) {
		this.repository = repository;
	}
	
	public List<Publicacao> findByUsuarioAndStatusExcluido(Usuario usuario) {
		return this.repository.findByUsuarioAndStatusOrderByIdDesc(usuario, false);
	}
	
	public List<Publicacao> getAllLast10() {
		return this.repository.getAllLast10();
	}
}
