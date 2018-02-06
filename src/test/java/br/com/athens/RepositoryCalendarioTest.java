package br.com.athens;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

import br.com.athens.domains.Calendario;
import br.com.athens.domains.TipoUsuario;
import br.com.athens.domains.Usuario;
import br.com.athens.repositories.RepositoryCalendario;
import br.com.athens.repositories.RepositoryUsuario;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryCalendarioTest {

	@Autowired
	private RepositoryCalendario repositoryCalendario;
	
	@Autowired
	private RepositoryUsuario repositoryUsuario;
	
	@Before
    public void setUp() throws Exception {
		repositoryCalendario.deleteAll();
    }
	
	@Test 
	public void addCalendarioTest() {		
		Calendario calendario = new Calendario();		
		calendario.setBloco("Bloco Administrativo");
		calendario.setDataCadastro(new Date());
		calendario.setDescricao("Teoria Musical Part 1");				
		
		Calendar dtInicial = new GregorianCalendar(2018,7,20);				
		Calendar dtFinal = new GregorianCalendar(2018,7,21);
		calendario.setDtInicio(dtInicial);
		calendario.setDtFinal(dtFinal);				
		
		Date date = new Date();
		Calendar hrCalendar = GregorianCalendar.getInstance();
		hrCalendar.setTime(date);   
		hrCalendar.get(Calendar.HOUR_OF_DAY);
		hrCalendar.get(Calendar.HOUR);       
		hrCalendar.get(Calendar.MONTH); 
        
		calendario.setHrFinal(hrCalendar);
		calendario.setHrInicio(hrCalendar);
		
		calendario.setSala("Sala 1");
		calendario.setStatusExcluido(false);
		calendario.setTitulo("Evento Musical");
		
		repositoryCalendario.save(calendario);
		Calendario calendarioBanco = new Calendario();
		calendarioBanco = repositoryCalendario.getCalendarioByTitulo("Evento Musical");
		assertEquals("Evento Musical", calendarioBanco.getTitulo());
	}
	
	@Test 
	public void alterCalendarioTest() {
		
		Calendario calendario = new Calendario();
		
		calendario.setBloco("Bloco de Ensino");
		calendario.setDataCadastro(new Date());
		calendario.setDescricao("Conjunto inicial de ensinamentos tecnologicos para o mundo dos negócios");				
		
		Calendar dtInicial = new GregorianCalendar(2018,7,20);				
		Calendar dtFinal = new GregorianCalendar(2018,7,21);
		calendario.setDtInicio(dtInicial);
		calendario.setDtFinal(dtFinal);				
		
		Date date = new Date();
		Calendar hrCalendar = GregorianCalendar.getInstance();
		hrCalendar.setTime(date);   
		hrCalendar.get(Calendar.HOUR_OF_DAY);
		hrCalendar.get(Calendar.HOUR);       
		hrCalendar.get(Calendar.MONTH); 
        
		calendario.setHrFinal(hrCalendar);
		calendario.setHrInicio(hrCalendar);
		
		calendario.setSala("Sala 1");
		calendario.setStatusExcluido(false);
		calendario.setTitulo("Mundo dos negócios");
		
		repositoryCalendario.save(calendario);
		
		calendario.setTitulo("Tecnologia no Mundo dos Negócios");
		repositoryCalendario.save(calendario);
		
		Calendario calendarioBanco = new Calendario();
		calendarioBanco = repositoryCalendario.getCalendarioByTitulo("Tecnologia no Mundo dos Negócios");
		
		assertEquals("Tecnologia no Mundo dos Negócios", calendarioBanco.getTitulo());
	}
	
	@Test 
	public void deleteCalendarioTest() {
		
		Calendario calendario = new Calendario();
		
		calendario.setBloco("Bloco de Ensino");
		calendario.setDataCadastro(new Date());
		calendario.setDescricao("Conjunto inicial de ensinamentos tecnologicos para o mundo dos negócios");				
		
		Calendar dtInicial = new GregorianCalendar(2018,7,20);				
		Calendar dtFinal = new GregorianCalendar(2018,7,21);
		calendario.setDtInicio(dtInicial);
		calendario.setDtFinal(dtFinal);				
		
		Date date = new Date();
		Calendar hrCalendar = GregorianCalendar.getInstance();
		hrCalendar.setTime(date);   
		hrCalendar.get(Calendar.HOUR_OF_DAY);
		hrCalendar.get(Calendar.HOUR);       
		hrCalendar.get(Calendar.MONTH); 
        
		calendario.setHrFinal(hrCalendar);
		calendario.setHrInicio(hrCalendar);
		
		calendario.setSala("Sala 1");
		calendario.setStatusExcluido(false);
		calendario.setTitulo("Negócios");
		
		repositoryCalendario.save(calendario);
		
		Calendario calendarioBanco = new Calendario();
		calendarioBanco = repositoryCalendario.getCalendarioByTitulo("Negócios");
		
		assertEquals("Negócios", calendarioBanco.getTitulo());		
		repositoryCalendario.delete(calendarioBanco);
	}
	
	@Test 
	public void getAllCalendarioTest() {
		
		Calendario calendario = new Calendario();		
		calendario.setBloco("Bloco de Ensino");
		calendario.setDataCadastro(new Date());
		calendario.setDescricao("Conjunto inicial de ensinamentos tecnologicos para o mundo dos negócios");						
		Calendar dtInicial = new GregorianCalendar(2018,7,20);				
		Calendar dtFinal = new GregorianCalendar(2018,7,21);
		calendario.setDtInicio(dtInicial);
		calendario.setDtFinal(dtFinal);						
		Date date = new Date();
		Calendar hrCalendar = GregorianCalendar.getInstance();
		hrCalendar.setTime(date);   
		hrCalendar.get(Calendar.HOUR_OF_DAY);
		hrCalendar.get(Calendar.HOUR);       
		hrCalendar.get(Calendar.MONTH);         
		calendario.setHrFinal(hrCalendar);
		calendario.setHrInicio(hrCalendar);		
		calendario.setSala("Sala 1");
		calendario.setStatusExcluido(false);
		calendario.setTitulo("Negócios");		
		repositoryCalendario.save(calendario);
		
		Calendario calendario2 = new Calendario();		
		calendario2.setBloco("Ensino");
		calendario2.setDataCadastro(new Date());
		calendario2.setDescricao("Let's Go With Arduino!");						
		Calendar dtInicial2 = new GregorianCalendar(2018,3,20);				
		Calendar dtFinal2 = new GregorianCalendar(2018,5,21);
		calendario2.setDtInicio(dtInicial2);
		calendario2.setDtFinal(dtFinal2);						
		Date date2 = new Date();
		Calendar hrCalendar2 = GregorianCalendar.getInstance();
		hrCalendar.setTime(date2);   
		hrCalendar2.get(Calendar.HOUR_OF_DAY);
		hrCalendar2.get(Calendar.HOUR);       
		hrCalendar2.get(Calendar.MONTH);         
		calendario2.setHrFinal(hrCalendar2);
		calendario2.setHrInicio(hrCalendar);		
		calendario2.setSala("Sala 1");
		calendario2.setStatusExcluido(false);
		calendario2.setTitulo("Arduíno");		
		
		repositoryCalendario.save(calendario);
		repositoryCalendario.save(calendario2);
		
		List<Calendario> calendarios = new LinkedList<>();
		calendarios = (List<Calendario>) repositoryCalendario.findAll();		
		assertEquals(2, calendarios.size());
	}
	
	@Test
	public void addCalendarioUsuario( ) {
		
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
		usuario = repositoryUsuario.save(usuario);

		Usuario usuario2 = new Usuario();
		usuario2.setDataCadastro(new Date());
		usuario2.setEmail("aliceNaoEscreva@gmail.com");
		usuario2.setTipoUsuario(TipoUsuario.SERVIDOR);
		usuario2.setNome("Alice Não escreva aquela carta de amor");
		usuario2.setPin(7621);
		usuario2.setSenha("senha#341");
		usuario2.setStatusExcluido(false);
		usuario2 = repositoryUsuario.save(usuario2);			
		
		Calendario calendario = new Calendario();		
		calendario.setBloco("Bloco de Ensino");
		calendario.setDataCadastro(new Date());
		calendario.setDescricao("Conjunto inicial de ensinamentos tecnologicos para o mundo dos negócios");						
		Calendar dtInicial = new GregorianCalendar(2018,7,20);				
		Calendar dtFinal = new GregorianCalendar(2018,7,21);
		calendario.setDtInicio(dtInicial);
		calendario.setDtFinal(dtFinal);						
		Date date = new Date();
		Calendar hrCalendar = GregorianCalendar.getInstance();
		hrCalendar.setTime(date);   
		hrCalendar.get(Calendar.HOUR_OF_DAY);
		hrCalendar.get(Calendar.HOUR);       
		hrCalendar.get(Calendar.MONTH);         
		calendario.setHrFinal(hrCalendar);
		calendario.setHrInicio(hrCalendar);		
		calendario.setSala("Sala 1");
		calendario.setStatusExcluido(false);
		calendario.setTitulo("Negócios");
		calendario.addUsuario(usuario);
		calendario.addUsuario(usuario2);
		repositoryCalendario.save(calendario);
		
		Calendario calendarioDB = repositoryCalendario.findOne(calendario.getId());
		assertEquals(2, calendario.getUsuarios().size());
		
		
	}
}
