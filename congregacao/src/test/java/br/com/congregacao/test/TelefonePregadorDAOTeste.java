package br.com.congregacao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.TelefonePregador;
import br.com.congregacao.model.TipoTelefone;
import br.com.congregacao.model.dao.TelefonePregadorDAO;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataConfig.class})
public class TelefonePregadorDAOTeste {

	@Autowired
	private TelefonePregadorDAO dao;
	
	@Before
	public void inicializar(){
		System.out.println( "Limpar tabela" );
		dao.removerTodos();
	}
	
	@Test
	public void tabelaDeveEstarVazia(){
		assertEquals( 0, dao.listarTodos().size() );
	}
	
	@Test
	public void deveInserirUmTelefone(){
		inserirUmTelefonePregador();
		assertEquals( 1, dao.listarTodos().size() );
	}
	
	@Test
	public void deveAtualizarUmTelefone(){
		TelefonePregador atualizar = dao.buscarPorId( inserirUmTelefonePregador().getId() );
		atualizar.setNumero("222222222");
		atualizar.setTipoTelefone( new TipoTelefone(1, "residencial"));
		dao.inserirOuAtualizar(atualizar);
		assertEquals("222222222", atualizar.getNumero());
	}
	
	@Test
	public void deveRemoverUmTelefone(){
		boolean removeu = dao.remover( inserirUmTelefonePregador().getId());
		assertEquals( true, removeu );
		
	}
	
	private TelefonePregador inserirUmTelefonePregador(){
		TelefonePregador telefone = new TelefonePregador();
		telefone.setNumero("991874268");
		telefone.setPregadorId(31);
		TipoTelefone tipo = new TipoTelefone( 1, "comercial" );
		telefone.setTipoTelefone(tipo);
		dao.inserirOuAtualizar(telefone);
		return telefone;
	}
}
