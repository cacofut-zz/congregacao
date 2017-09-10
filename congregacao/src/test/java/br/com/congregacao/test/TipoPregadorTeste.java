package br.com.congregacao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.TipoPregador;
import br.com.congregacao.model.dao.TipoPregadorDAO;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { DataConfig.class } )
public class TipoPregadorTeste {

	@Autowired
	private TipoPregadorDAO dao;
	
	@Before
	public void inicializa(){
		System.out.println( "Limpando a tabela" );
		dao.removerTodos();
	}
	
	@Test
	public void tabelaDeveEstarVazia(){
		assertEquals(0, dao.listarTodos().size());
	}
	
	@Test
	public void deveInserirUmTipoPregador(){
		inserirUmTipoPregador();
		assertEquals(1, dao.listarTodos().size());
	}
	
	@Test
	public void deveAtualizarUmTipoPregador(){
		TipoPregador tipoSalvo = inserirUmTipoPregador();
		TipoPregador tipoAtualizar = dao.buscarPorId( tipoSalvo.getId() );
		tipoAtualizar.setNome("pioneiro regular");
		dao.inserirOuAtualizar(tipoAtualizar);
		assertEquals("pioneiro regular", tipoAtualizar.getNome());
		
	}
	
	@Test
	public void deveRemoverUmTipoPregador(){
		inserirUmTipoPregador();
		TipoPregador tipoPregador = dao.listarTodos().get(0);
		boolean removeu = dao.remover(tipoPregador.getId());
		assertEquals( true , removeu );
	}
	
	private TipoPregador inserirUmTipoPregador(){
		TipoPregador tipoPregador = new TipoPregador( "publicador" );
		dao.inserirOuAtualizar( tipoPregador );
		return tipoPregador;
	}
}
