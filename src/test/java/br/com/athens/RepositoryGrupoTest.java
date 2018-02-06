package br.com.athens;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.athens.domains.Ambiente;
import br.com.athens.domains.Grupo;
import br.com.athens.repositories.RepositoryGrupo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryGrupoTest {
	
	@Autowired
	private RepositoryGrupo repositoryGrupo;
		
	@Before
    public void setUp() throws Exception {
		repositoryGrupo.deleteAll();
    }
	
	@Test 
	public void addGrupo() {					
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);
		
		
		Grupo grupo2 = new Grupo();
		grupo2.setAmbiente(Ambiente.EXTERNO);
		grupo2.setDataCadastro(new Date());
		grupo2.setDescricao("Projeto de Extensão teste");
		grupo2.setDtInicio(new GregorianCalendar(2017,10,11));			
		grupo2.setStatusExcluido(false);
		grupo2.setTitulo("Projeto de Extensão teste");
		grupo2 = repositoryGrupo.save(grupo2);				
		
		assertFalse(grupo.getId() == 0 && grupo2.getId() == 0);
	}	

	@Test
	public void listGrupos() {
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);
		
		Grupo grupo2 = new Grupo();
		grupo2.setAmbiente(Ambiente.EXTERNO);
		grupo2.setDataCadastro(new Date());
		grupo2.setDescricao("Projeto de Extensão teste");
		grupo2.setDtInicio(new GregorianCalendar(2017,10,11));			
		grupo2.setStatusExcluido(false);
		grupo2.setTitulo("Projeto de Extensão teste");
		grupo2 = repositoryGrupo.save(grupo2);				

		List<Grupo> grupos = (List<Grupo>) repositoryGrupo.findAll();
		assertTrue(grupos.size() == 2);
	}

	@Test
	public void findByIdGrupo() {
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);

		Grupo grupoDB = repositoryGrupo.findOne(grupo.getId());
		assertEquals(grupo, grupoDB);
	}
	
	@Test
	public void alterGrupo() {
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);

		Grupo grupoDB = repositoryGrupo.findOne(grupo.getId());
		final String descricao = "Alterado o grupo"; 
		grupoDB.setDescricao(descricao);
		grupoDB = repositoryGrupo.save(grupoDB);
		
		Grupo grupoDBAlterada = repositoryGrupo.findOne(grupo.getId()); 
		assertEquals(descricao, grupoDBAlterada.getDescricao());
		
	}
	
	@Test
	public void deleteGrupo() {
		Grupo grupo = new Grupo();
		grupo.setAmbiente(Ambiente.INTERNO);
		grupo.setDataCadastro(new Date());
		grupo.setDescricao("Projeto de Extensão Adiato");
		grupo.setDtInicio(new GregorianCalendar(2017,1,31));			
		grupo.setStatusExcluido(false);
		grupo.setTitulo("Projeto de Extensão");
		grupo = repositoryGrupo.save(grupo);
		
		repositoryGrupo.delete(grupo.getId());
		
		Grupo grupoDB = repositoryGrupo.findOne(grupo.getId());
		
		assertNull(grupoDB);
		
	}
	
	
	
}
