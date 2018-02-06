package br.com.athens;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.athens.domains.TipoUsuario;
import br.com.athens.domains.Usuario;
import br.com.athens.repositories.RepositoryCalendario;
import br.com.athens.repositories.RepositoryGrupo;
import br.com.athens.repositories.RepositoryGrupoPublicacao;
import br.com.athens.repositories.RepositoryNotificacao;
import br.com.athens.repositories.RepositoryPublicacao;
import br.com.athens.repositories.RepositoryUsuario;
import br.com.athens.repositories.RepositoryUsuarioNotificacao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryUsuarioTest {
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;		
	
	@Autowired
	private RepositoryGrupoPublicacao repositoryGrupoPublicacao;
	
	@Autowired
	private RepositoryCalendario repositoryCalendario;
	
	@Autowired
	private RepositoryPublicacao repositoryPublicacao;	
	
	@Autowired
	private RepositoryGrupo repositoryGrupo;
	
	@Autowired
	RepositoryNotificacao repositoryNotificacao;
	
	@Autowired
	RepositoryUsuarioNotificacao repositoryUsuarioNotificacao;
	
	@Before
    public void setUp() throws Exception {
		repositoryCalendario.deleteAll();
		repositoryGrupoPublicacao.deleteAll();
		repositoryPublicacao.deleteAll();
		repositoryGrupo.deleteAll();
		repositoryUsuarioNotificacao.deleteAll();
		repositoryNotificacao.deleteAll();
		repositoryUsuario.deleteAll();		
    }
	
	@Test 
	public void addUsuarioTest() {					
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("louise@gmail.com");
		usuario.setNome("Louise");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
		usuario.setPin(4321);
		usuario.setSenha("senha#321");
		usuario.setStatusExcluido(false);
		repositoryUsuario.save(usuario);			
		Usuario usuarioBanco = new Usuario();		
		usuarioBanco = repositoryUsuario.getUsuaryByEmail("louise@gmail.com");			
		assertEquals("Nome deverá ser Louise ", "Louise", usuarioBanco.getNome());			
	}	
	
	@Test
	public void alterUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
		usuario.setEmail("alice@gmail.com");
		usuario.setNome("Alice");
		usuario.setPin(7621);
		usuario.setSenha("senha#341");
		usuario.setStatusExcluido(false);
		repositoryUsuario.save(usuario);			
		usuario.setNome("Alice Miller");
		repositoryUsuario.save(usuario);	
		
		Usuario usuarioBanco = new Usuario();		
		usuarioBanco = repositoryUsuario.getUsuaryByEmail("alice@gmail.com");		
		assertEquals("Nome deverá ser Alice Miller ", "Alice Miller", usuarioBanco.getNome());
	}
	
	
	@Test
	public void getAllUsuarioTest() {
		repositoryUsuario.deleteAll();
		
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("alice@gmail.com");
		usuario.setTipoUsuario(TipoUsuario.SERVIDOR);
		usuario.setNome("Alice");
		usuario.setPin(7621);
		usuario.setSenha("senha#341");
		usuario.setStatusExcluido(false);
		repositoryUsuario.save(usuario);			
		usuario.setNome("Alice Miller");
		repositoryUsuario.save(usuario);	
		
		List<Usuario> usuarios = new LinkedList<>();
		usuarios = (List<Usuario>) repositoryUsuario.findAll();		
		assertEquals(1, usuarios.size());
	}
	
	@Test
	public void deleteUsuarioTest() {		
		
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("mario@gmail.com");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
		usuario.setNome("Mario");
		usuario.setPin(7621);
		usuario.setSenha("senha#341");
		usuario.setStatusExcluido(false);
		repositoryUsuario.save(usuario);							
		
		Usuario usuarioBanco = new Usuario();		
		usuarioBanco = repositoryUsuario.getUsuaryByEmail("mario@gmail.com");		
		assertEquals("NOME "+usuarioBanco.getNome(), "Mario", usuarioBanco.getNome());
		
		repositoryUsuario.delete(usuario);			
	}

	
}
