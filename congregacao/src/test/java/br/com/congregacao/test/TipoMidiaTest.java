package br.com.congregacao.test;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.TipoMidia;
import br.com.congregacao.model.dao.TipoMidiaDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = DataConfig.class )
public class TipoMidiaTest {

	/*
		TipoMidia [id=1, nome=livro]
		TipoMidia [id=4, nome=panfletos]
		TipoMidia [id=3, nome=revista]
		TipoMidia [id=2, nome=video]
	**/
	
	@Autowired
	private TipoMidiaDAO tipoMidiaDAO;
	
	@Test
	public void testeSelecionarTodos(){
		tipoMidiaDAO.listarTodos().forEach( t -> System.out.println( t ) );
	}
	
	@Test
	public void testeSelecionarPorId(){
		System.out.println( tipoMidiaDAO.buscarPorId( 1 ));
	}
	
	public void testeInsert(){
		TipoMidia tipoMidia = new TipoMidia( "panfletos" );
		tipoMidiaDAO.inserirOuAtualizar( tipoMidia );
		tipoMidiaDAO.listarTodos().forEach( t -> System.out.println( t ) );		
	}
	
	public void testeUpdate(){
		TipoMidia tipoMidia = new TipoMidia( 4, "panfletos" );
		tipoMidiaDAO.inserirOuAtualizar( tipoMidia );
		tipoMidiaDAO.listarTodos().forEach( t -> System.out.println( t ) );
	}
	
	@Test
	public void testeRemover(){
		System.out.println( tipoMidiaDAO.remover( 4 ) );
		tipoMidiaDAO.listarTodos().forEach( t -> System.out.println( t ) );
	}
}
