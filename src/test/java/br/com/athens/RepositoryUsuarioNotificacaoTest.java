package br.com.athens;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.athens.domains.Notificacao;
import br.com.athens.domains.TipoUsuario;
import br.com.athens.domains.Usuario;
import br.com.athens.domains.UsuarioNotificacao;
import br.com.athens.repositories.RepositoryNotificacao;
import br.com.athens.repositories.RepositoryUsuario;
import br.com.athens.repositories.RepositoryUsuarioNotificacao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryUsuarioNotificacaoTest {

	@Autowired
	RepositoryUsuarioNotificacao repositoryUsuarioNotificacao;
	
	@Autowired
	RepositoryNotificacao repositoryNotificacao;
	
	@Autowired
	RepositoryUsuario repositoryUsuario;
	
	@Before
    public void setUp() throws Exception {
		repositoryUsuarioNotificacao.deleteAll();
    }
	
	@Test
	public void addUsuarioNotificacao() {
		Notificacao notificacao = new Notificacao();
		notificacao.setDataCadastro(new Date());
		notificacao.setDescricao("Você esta recebendo um teste");
		notificacao.setStatusExcluido(false);
		notificacao = repositoryNotificacao.save(notificacao);
		
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("louise@gmail.com");
		usuario.setNome("Louise");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
		usuario.setPin(4321);
		usuario.setSenha("senha#321");
		usuario.setStatusExcluido(false);
		repositoryUsuario.save(usuario);
		
		UsuarioNotificacao usuarioNotificacao = new UsuarioNotificacao();
		usuarioNotificacao.setUsuario(usuario);
		usuarioNotificacao.setNotificacao(notificacao);
		usuarioNotificacao.setStatusVisualizacao(false);
		usuarioNotificacao = repositoryUsuarioNotificacao.save(usuarioNotificacao);
		
		assertTrue(usuarioNotificacao.getId() > 0);
	}
	
	@Test
	public void setNotificacaoVisualizada() {
		Notificacao notificacao = new Notificacao();
		notificacao.setDataCadastro(new Date());
		notificacao.setDescricao("Você esta recebendo um teste");
		notificacao.setStatusExcluido(false);
		notificacao = repositoryNotificacao.save(notificacao);
		
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("louise@gmail.com");
		usuario.setNome("Louise");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
		usuario.setPin(4321);
		usuario.setSenha("senha#321");
		usuario.setStatusExcluido(false);
		repositoryUsuario.save(usuario);
		
		UsuarioNotificacao usuarioNotificacao = new UsuarioNotificacao();
		usuarioNotificacao.setUsuario(usuario);
		usuarioNotificacao.setNotificacao(notificacao);
		usuarioNotificacao.setStatusVisualizacao(false);
		usuarioNotificacao = repositoryUsuarioNotificacao.save(usuarioNotificacao);
		
		UsuarioNotificacao usuarioNotificacaoDB = repositoryUsuarioNotificacao.findOne(usuarioNotificacao.getId());
		usuarioNotificacaoDB.setStatusVisualizacao(true);
		repositoryUsuarioNotificacao.save(usuarioNotificacaoDB);
		
		UsuarioNotificacao usuarioNotificacaoValidacao = repositoryUsuarioNotificacao.findOne(usuarioNotificacao.getId());
		assertTrue(usuarioNotificacaoValidacao.getStatusVisualizacao());		
	}
	
}
