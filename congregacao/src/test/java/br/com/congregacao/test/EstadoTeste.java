package br.com.congregacao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Estado;
import br.com.congregacao.model.dao.EstadoDAO;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { DataConfig.class } )
public class EstadoTeste {

	@Autowired
	private EstadoDAO dao;
	
	@Before
	public void inicializar(){
		System.out.println( "Limpando a tabela" );
		dao.removerTodos();
	}
	
	@Test
	public void tabelaDeveEstarVazia(){
		assertEquals( 0 , dao.listarTodos().size());
	}
	
	@Test
	public void deveInserirUmEstado(){
		inserirUmEstado();
		assertEquals( 1 , dao.listarTodos().size());
	}
	
	@Test
	public void deveAtualizarUmEstado(){
		Estado estadoSalvo = dao.buscarPorId( inserirUmEstado().getId());
		estadoSalvo.setNome( "Rio de Janeiro" );
		estadoSalvo.setSigla( "rj" );
		dao.inserirOuAtualizar( estadoSalvo );
		assertEquals("Rio de Janeiro", estadoSalvo.getNome());
	}
	
	@Test
	public void deveRemoverUmEstado(){
		inserirUmEstado();
		Estado estado   = dao.listarTodos().get(0);
		boolean removeu = dao.remover(estado.getId());
		assertEquals(true, removeu);
		
	}
	
	private Estado inserirUmEstado(){
		Estado estado = new Estado( "São Paulo", "sp" );
		dao.inserirOuAtualizar( estado );
		return estado;
	}
	
	
}
