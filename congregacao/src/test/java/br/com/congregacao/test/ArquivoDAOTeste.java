package br.com.congregacao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.dao.ArquivoDAO;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { DataConfig.class } )
public class ArquivoDAOTeste {

	@Autowired
	private ArquivoDAO dao;
	
	@Before
	public void inicializar(){
		System.out.println( "Limpar tabela" );
		dao.removerTodos();
	}
	
	@Test
	public void tabelaDeveEstarVazia(){
		assertEquals( 0 , dao.listarTodos().size());
	}
	
	@Test
	public void deveInserirUmArquivo(){
		inserirUmArquivo();
		assertEquals( 1, dao.listarTodos().size() );
	}
	
	@Test
	public void deveAtualizarUmArquivo(){
		inserirUmArquivo();
		Arquivo atualizar = dao.listarTodos().get(0);
		atualizar.setNome( "spring" );
		atualizar.setDiretorio( "/docs" );
		atualizar.setExtencao( ".pdf" );
		assertEquals( "spring", dao.inserirOuAtualizar(atualizar).getNome() );
		
	}
	
	@Test
	public void deveRemoverUmArquivo(){
		boolean removeu = dao.remover(inserirUmArquivo().getId());	
		assertEquals( true, removeu );
	}
	
	@Test
	public void arquivoInexistente(){
		System.out.println( dao.buscarPorId(2) );
	}
	
	private Arquivo inserirUmArquivo(){
		Arquivo arquivo = new Arquivo();
		arquivo.setNome( "teste" );
		arquivo.setDiretorio( "/teste" );
		arquivo.setExtencao( ".teste" );		
		return dao.inserirOuAtualizar( arquivo );
	}
}
