package br.com.congregacao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Pais;
import br.com.congregacao.model.dao.PaisDAO;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { DataConfig.class } )
public class PaisDAOTeste {

	@Autowired
	private PaisDAO dao;
	
	@Before
	public void inicializar(){
		System.out.println( "Limpar a tabela pais" );
		dao.removerTodos();
	}
	
	@Test
	public void tabelaDeveEstarVazia(){
		List<Pais> paises = dao.listarTodos();
		assertEquals( 0 , paises.size());
	}
	
	@Test
	public void deveInserirUmPais(){
		Pais pais  = inserirUmPais();
		Pais salvo = dao.buscarPorId( pais.getId() );
		assertEquals(salvo.getNome(), pais.getNome());
	}
	
	@Test
	public void deveAtualizarUmPais(){
		inserirUmPais();
		Pais pais = dao.listarTodos().get(0);
		pais.setNome( "Argentina" );
		pais.setSigla( "ar" );
		dao.inserirOuAtualizar( pais );
		Pais paisAtualizado = dao.buscarPorId( pais.getId() );
		assertEquals( paisAtualizado.getNome(), pais.getNome() );
	}
	
	@Test
	public void deveRemoverUmPais(){
		inserirUmPais();
		Pais pais = dao.listarTodos().get(0);
		boolean removeu = dao.remover( pais.getId() );
		assertEquals( true , removeu );
	}
	
	private Pais inserirUmPais(){
		Pais pais = new Pais( "Brasil", "br" );
		dao.inserirOuAtualizar( pais );
		return pais;
	}
	

}
