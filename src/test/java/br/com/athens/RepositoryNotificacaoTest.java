package br.com.athens;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.athens.domains.Notificacao;
import br.com.athens.repositories.RepositoryNotificacao;
import br.com.athens.repositories.RepositoryUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RepositoryNotificacaoTest {
	
	@Autowired
	RepositoryNotificacao repositoryNotificacao;
	
	@Autowired
	RepositoryUsuario repositoryUsuario;
	
	@Before
    public void setUp() throws Exception {
		repositoryNotificacao.deleteAll();		
    }
	
	@Test
	public void addNotificacao() {
		Notificacao notificacao = new Notificacao();
		notificacao.setDataCadastro(new Date());
		notificacao.setDescricao("Você esta recebendo um teste");
		notificacao.setStatusExcluido(false);
		notificacao = repositoryNotificacao.save(notificacao);
		
		Notificacao notificacao2 = new Notificacao();
		notificacao2.setDataCadastro(new Date());
		notificacao2.setDescricao("Você esta recebendo um teste2");
		notificacao2.setStatusExcluido(false);
		notificacao2 = repositoryNotificacao.save(notificacao2);
		
		assertTrue(notificacao.getId() >0 && notificacao2.getId() > 0);
	}
	
	@Test
	public void listNotificacoes() {
		Notificacao notificacao = new Notificacao();
		notificacao.setDataCadastro(new Date());
		notificacao.setDescricao("Você esta recebendo um teste para listatem 1");
		notificacao.setStatusExcluido(false);
		notificacao = repositoryNotificacao.save(notificacao);
		
		Notificacao notificacao2 = new Notificacao();
		notificacao2.setDataCadastro(new Date());
		notificacao2.setDescricao("Você esta recebendo um teste para listatem 2");
		notificacao2.setStatusExcluido(false);
		notificacao2 = repositoryNotificacao.save(notificacao2);
		
		List<Notificacao> notificacoes = (List<Notificacao>) repositoryNotificacao.findAll();
		
		assertEquals(2, notificacoes.size());	
	}
	
	@Test
	public void findByIdNotificacao() {
		Notificacao notificacao = new Notificacao();
		notificacao.setDataCadastro(new Date());
		notificacao.setDescricao("Você esta recebendo um teste");
		notificacao.setStatusExcluido(false);
		notificacao = repositoryNotificacao.save(notificacao);
		
		Notificacao notificacaoDB = repositoryNotificacao.findOne(notificacao.getId());
		
		assertEquals(notificacao, notificacaoDB);
		
	}
	
	@Test
	public void alterNotificacao() {
		Notificacao notificacao = new Notificacao();
		notificacao.setDataCadastro(new Date());
		notificacao.setDescricao("Você esta recebendo um teste");
		notificacao.setStatusExcluido(false);
		notificacao = repositoryNotificacao.save(notificacao);
		
		Notificacao notificacaoDB = repositoryNotificacao.findOne(notificacao.getId());
		final String descricao = "Notificacao Alterada";
		notificacaoDB.setDescricao(descricao);
		notificacaoDB = repositoryNotificacao.save(notificacaoDB);
		
		Notificacao notificacaoDBAlterada = repositoryNotificacao.findOne(notificacao.getId());
		assertEquals(descricao, notificacaoDBAlterada.getDescricao());		
	}
	
	@Test
	public void deleteNotificacao() {
		Notificacao notificacao = new Notificacao();
		notificacao.setDataCadastro(new Date());
		notificacao.setDescricao("Você esta recebendo um teste");
		notificacao.setStatusExcluido(false);
		notificacao = repositoryNotificacao.save(notificacao);
		
		repositoryNotificacao.delete(notificacao.getId());
		
		Notificacao notificacaoDB = repositoryNotificacao.findOne(notificacao.getId());
		assertNull(notificacaoDB);
	}

}
