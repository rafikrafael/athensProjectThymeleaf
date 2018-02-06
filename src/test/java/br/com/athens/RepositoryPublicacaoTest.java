package br.com.athens;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.athens.domains.Publicacao;
import br.com.athens.domains.TipoUsuario;
import br.com.athens.domains.Usuario;
import br.com.athens.repositories.RepositoryGrupo;
import br.com.athens.repositories.RepositoryGrupoPublicacao;
import br.com.athens.repositories.RepositoryPublicacao;
import br.com.athens.repositories.RepositoryUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryPublicacaoTest {

	@Autowired
	private RepositoryPublicacao repositoryPublicacao;	
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;
	
	@Autowired
	private RepositoryGrupo repositoryGrupo;
	
	@Autowired
	private RepositoryGrupoPublicacao repositoryGrupoPublicacao;	
	
	@Before
    public void setUp() throws Exception {
		repositoryGrupoPublicacao.deleteAll();
		repositoryGrupo.deleteAll();
		repositoryPublicacao.deleteAll();			
		repositoryUsuario.deleteAll();
    }
	
	@Test
	public void AddPublicacaoTest() {
		
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("louise@gmail.com");
		usuario.setNome("Louise");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
		usuario.setPin(4321);
		usuario.setSenha("senha#321");
		usuario.setStatusExcluido(false);
		usuario = repositoryUsuario.save(usuario);
		
		Publicacao publicacao = new Publicacao();
		publicacao.setDataCadastro(new Date());
		publicacao.setTitulo("Vestibular IFPR");
		publicacao.setDescricao("As incrições acabaram");		
		publicacao.setStatusExcluido(false);	
		publicacao.setUsuario(usuario);
		repositoryPublicacao.save(publicacao);
		
		Publicacao publicacao2 = new Publicacao();
		publicacao2.setDataCadastro(new Date());
		publicacao2.setTitulo("Evento de Robótica");
		publicacao2.setDescricao("O evento de Robótica iniciará na próxima semana");		
		publicacao2.setStatusExcluido(false);		
		publicacao2.setUsuario(usuario);
		repositoryPublicacao.save(publicacao2);
		List<Publicacao> publicacoes = new LinkedList<>(); 
		publicacoes = (List<Publicacao>) repositoryPublicacao.findAll();
		
		assertEquals(2, publicacoes.size());
	}
	
	@Test
	public void alterPublicacaoTest() {		
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("louise@gmail.com");
		usuario.setNome("Louise");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
		usuario.setPin(4321);
		usuario.setSenha("senha#321");
		usuario.setStatusExcluido(false);
		usuario = repositoryUsuario.save(usuario);
		
		Publicacao publicacao = new Publicacao();
		publicacao.setDataCadastro(new Date());
		publicacao.setTitulo("Vestibular IFPR");
		publicacao.setDescricao("Teste de alteração de Publicacao");		
		publicacao.setStatusExcluido(false);	
		publicacao.setUsuario(usuario);
		repositoryPublicacao.save(publicacao);
		publicacao.setTitulo("IFPR é TOP");
		repositoryPublicacao.save(publicacao);
		
		List<Publicacao> publicacaoBanco = new LinkedList<>();
		publicacaoBanco = repositoryPublicacao.getPublicacaoByTitulo("IFPR é TOP");
		assertEquals("IFPR é TOP", publicacao.getTitulo());		
	}
	
	@Test
	public void deletePublicacaoTest() {		
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("louise@gmail.com");
		usuario.setNome("Louise");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
		usuario.setPin(4321);
		usuario.setSenha("senha#321");
		usuario.setStatusExcluido(false);
		usuario = repositoryUsuario.save(usuario);
				
		Publicacao publicacao = new Publicacao();
		publicacao.setDataCadastro(new Date());
		publicacao.setTitulo("Vestibular IFPR");
		publicacao.setDescricao("As incrições acabaram");		
		publicacao.setStatusExcluido(false);	
		publicacao.setUsuario(usuario);
		repositoryPublicacao.save(publicacao);
		
		Publicacao publicacao2 = new Publicacao();
		publicacao2.setDataCadastro(new Date());
		publicacao2.setTitulo("Evento de Robótica");
		publicacao2.setDescricao("O evento de Robótica iniciará na próxima semana");		
		publicacao2.setStatusExcluido(false);		
		publicacao2.setUsuario(usuario);
		repositoryPublicacao.save(publicacao2);
		
		List<Publicacao> publicacaoBanco = new LinkedList<>();
		publicacaoBanco = repositoryPublicacao.getPublicacaoByTitulo("Vestibular IFPR");
		repositoryPublicacao.delete(publicacaoBanco);
		
		List<Publicacao> publicacoes = new LinkedList<>(); 
		publicacoes = (List<Publicacao>) repositoryPublicacao.findAll();
		assertEquals(1, publicacoes.size());		
	}
	
	@Test
	public void getAllPublicacaoTest() { 
		Usuario usuario = new Usuario();
		usuario.setDataCadastro(new Date());
		usuario.setEmail("louise@gmail.com");
		usuario.setNome("Louise");
		usuario.setTipoUsuario(TipoUsuario.ALUNO);
		usuario.setPin(4321);
		usuario.setSenha("senha#321");
		usuario.setStatusExcluido(false);
		usuario = repositoryUsuario.save(usuario);
		
		Publicacao publicacao = new Publicacao();
		publicacao.setDataCadastro(new Date());
		publicacao.setTitulo("Evento Nº 1");
		publicacao.setDescricao("Descrição número 1");		
		publicacao.setStatusExcluido(false);	
		publicacao.setUsuario(usuario);
		repositoryPublicacao.save(publicacao);
		
		Publicacao publicacao2 = new Publicacao();
		publicacao2.setDataCadastro(new Date());
		publicacao2.setTitulo("Evento Nº 2");
		publicacao2.setDescricao("Descrição número 2");		
		publicacao2.setStatusExcluido(false);		
		publicacao2.setUsuario(usuario);
		repositoryPublicacao.save(publicacao2);
		
		Publicacao publicacao3 = new Publicacao();
		publicacao3.setDataCadastro(new Date());
		publicacao3.setTitulo("Evento Nº 3");
		publicacao3.setDescricao("Descrição número 3");		
		publicacao3.setStatusExcluido(false);		
		publicacao3.setUsuario(usuario);
		repositoryPublicacao.save(publicacao3);
		
		Publicacao publicacao4 = new Publicacao();
		publicacao4.setDataCadastro(new Date());
		publicacao4.setTitulo("Evento Nº 4");
		publicacao4.setDescricao("Descrição número 4");		
		publicacao4.setStatusExcluido(false);		
		publicacao4.setUsuario(usuario);
		repositoryPublicacao.save(publicacao4);
		
		Publicacao publicacao5 = new Publicacao();
		publicacao5.setDataCadastro(new Date());
		publicacao5.setTitulo("Evento Nº 5");
		publicacao5.setDescricao("Descrição número 5");		
		publicacao5.setStatusExcluido(false);		
		publicacao5.setUsuario(usuario);
		repositoryPublicacao.save(publicacao5);
		
		List<Publicacao> publicacoes = new LinkedList<>(); 
		publicacoes = (List<Publicacao>) repositoryPublicacao.findAll();
		
		assertEquals(5, publicacoes.size());
	}
	
}
