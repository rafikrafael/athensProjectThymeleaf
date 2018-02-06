package br.com.athens;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.athens.domains.Ambiente;
import br.com.athens.domains.Grupo;
import br.com.athens.domains.GrupoPublicacao;
import br.com.athens.domains.Publicacao;
import br.com.athens.domains.TipoUsuario;
import br.com.athens.domains.Usuario;
import br.com.athens.repositories.RepositoryGrupo;
import br.com.athens.repositories.RepositoryGrupoPublicacao;
import br.com.athens.repositories.RepositoryPublicacao;
import br.com.athens.repositories.RepositoryUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryGrupoPublicacaoTest {

	@Autowired
	private RepositoryGrupo repositoryGrupo;	
	
	@Autowired
	private RepositoryPublicacao repositoryPublicacao;
	
	@Autowired
	private RepositoryGrupoPublicacao repositoryGrupoPublicacao;
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;
	
	@Before
    public void setUp() throws Exception {
		repositoryGrupoPublicacao.deleteAll();
    }
	
	@Test
	public void AddGrupoPublicacaoTest() {
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
		publicacao = repositoryPublicacao.save(publicacao);
		
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);
		
		GrupoPublicacao grupoPublicacao = new GrupoPublicacao();
		grupoPublicacao.setDataCadastro(new Date());
		grupoPublicacao.setGrupo(grupo);
		grupoPublicacao.setLiberada(true);
		grupoPublicacao.setPublicacao(publicacao);
		grupoPublicacao.setStatusExcluido(false);
		repositoryGrupoPublicacao.save(grupoPublicacao);
		
		GrupoPublicacao grupoPublicacao2 = new GrupoPublicacao();
		grupoPublicacao2.setDataCadastro(new Date());
		grupoPublicacao2.setGrupo(grupo);
		grupoPublicacao2.setLiberada(false);
		grupoPublicacao2.setPublicacao(publicacao);
		grupoPublicacao2.setStatusExcluido(false);
		repositoryGrupoPublicacao.save(grupoPublicacao2);		
		
		List<GrupoPublicacao> gruposPublicacoes = new LinkedList<>();
		gruposPublicacoes = repositoryGrupoPublicacao.getGrupoPublicacaoByLiberadas();
		assertEquals(1, gruposPublicacoes.size());
	}
	
	@Test
	public void alterGrupoPublicacaoTest() {
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
		publicacao = repositoryPublicacao.save(publicacao);
		
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);
		
		GrupoPublicacao grupoPublicacao = new GrupoPublicacao();
		grupoPublicacao.setDataCadastro(new Date());
		grupoPublicacao.setGrupo(grupo);
		grupoPublicacao.setLiberada(true);
		grupoPublicacao.setPublicacao(publicacao);
		grupoPublicacao.setStatusExcluido(false);
		repositoryGrupoPublicacao.save(grupoPublicacao);
		grupoPublicacao.setLiberada(false);			
		repositoryGrupoPublicacao.save(grupoPublicacao);
		
		List<GrupoPublicacao> gruposPublicacoes = new LinkedList<>();
		gruposPublicacoes = repositoryGrupoPublicacao.getGrupoPublicacaoByLiberadas();
		assertEquals(0, gruposPublicacoes.size());
	}
	
	@Test
	public void deleteGrupoPublicacaoTest() {
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
		publicacao = repositoryPublicacao.save(publicacao);
		
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);
		
		GrupoPublicacao grupoPublicacao = new GrupoPublicacao();
		grupoPublicacao.setDataCadastro(new Date());
		grupoPublicacao.setGrupo(grupo);
		grupoPublicacao.setLiberada(true);
		grupoPublicacao.setPublicacao(publicacao);
		grupoPublicacao.setStatusExcluido(false);
		repositoryGrupoPublicacao.save(grupoPublicacao);
		
		repositoryGrupoPublicacao.delete(grupoPublicacao);		
		List<GrupoPublicacao> gruposPublicacoes = new LinkedList<>();
		gruposPublicacoes = repositoryGrupoPublicacao.getGrupoPublicacaoByLiberadas();
		assertEquals(0, gruposPublicacoes.size());
	}
	
	@Test
	public void getAllGrupoPublicacaoTest() {
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
		publicacao = repositoryPublicacao.save(publicacao);
		
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);
		
		GrupoPublicacao grupoPublicacao = new GrupoPublicacao();
		grupoPublicacao.setDataCadastro(new Date());
		grupoPublicacao.setGrupo(grupo);
		grupoPublicacao.setLiberada(true);
		grupoPublicacao.setPublicacao(publicacao);
		grupoPublicacao.setStatusExcluido(false);
		repositoryGrupoPublicacao.save(grupoPublicacao);

		GrupoPublicacao grupoPublicacao2 = new GrupoPublicacao();
		grupoPublicacao2.setDataCadastro(new Date());
		grupoPublicacao2.setGrupo(grupo);
		grupoPublicacao2.setLiberada(true);
		grupoPublicacao2.setPublicacao(publicacao);
		grupoPublicacao2.setStatusExcluido(false);
		repositoryGrupoPublicacao.save(grupoPublicacao2);

		
		GrupoPublicacao grupoPublicacao3 = new GrupoPublicacao();
		grupoPublicacao3.setDataCadastro(new Date());
		grupoPublicacao3.setGrupo(grupo);
		grupoPublicacao3.setLiberada(true);
		grupoPublicacao3.setPublicacao(publicacao);
		grupoPublicacao3.setStatusExcluido(false);
		repositoryGrupoPublicacao.save(grupoPublicacao3);

		List<GrupoPublicacao> gruposPublicacoes = new LinkedList<>();
		gruposPublicacoes = (List<GrupoPublicacao>) repositoryGrupoPublicacao.findAll();
		assertEquals(3, gruposPublicacoes.size());
	}
}
