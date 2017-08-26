package br.com.congregacao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.dao.ArquivoDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = DataConfig.class )
public class ArquivoTest {

	@Autowired
	private ArquivoDAO arquivoDAO;
	
	@Test
	public void testeInsert(){
		Arquivo arquivo = new Arquivo();
		arquivo.setNome( "teste" );
		arquivo.setDiretorio( "/teste" );
		arquivo.setExtencao( ".tst" );
		
		arquivoDAO.inserirOuAtualizar( arquivo );
		System.out.println( arquivo );
		
	}
	
	@Test
	public void listarTodos(){
		arquivoDAO.listarTodos().forEach( a -> System.out.println( a ) );
	}
	
	//@Test
	public void testeRemover(){
		System.out.println( arquivoDAO.remover( 1 ) );
	}
	
	@Test
	public void listarPorId(){
		Arquivo arquivo = arquivoDAO.buscarPorId(1);
		System.out.println( arquivo );
	}
	
	

}
