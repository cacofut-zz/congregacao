package br.com.congregacao.test;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Midia;
import br.com.congregacao.model.TipoMidia;
import br.com.congregacao.model.dao.MidiaDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { DataConfig.class } )
public class MidiaTest {

	@Autowired
	private MidiaDAO midiaDAO;
	
	@Test
	public void testeBuscaPorId(){
		System.out.println( midiaDAO.buscarPorId( 1 ));
	}

	//@Test
	public void testeInsert(){
		
		Midia midia = new Midia();
		
		midia.setTitulo( "nova sentinela!" );
		midia.setQuantidade( 2 );
		midia.setTipoMidia( new TipoMidia( 3 ) );
		midia.setImagem   ( new Arquivo( 2 ) );
		midia.setPerfilData( LocalDate.of(2017, 5, 25) );
		midia.setPregadorId( 1 );
		midiaDAO.inserirOuAtualizar( midia );
		
	}
	
	//@Test
	public void testeUpdate(){
		
		Midia midia = new Midia();
		midia.setId( 1 );
		midia.setTitulo( "sentinela anunciando o reino de Deus!" );
		midia.setQuantidade( 6 );
		midia.setTipoMidia( new TipoMidia( 3 ) );
		midia.setImagem   ( new Arquivo( 2 ) );
		
		midiaDAO.inserirOuAtualizar( midia );
	}
	
	//@Test
	public void testeRemover(){
		System.out.println( midiaDAO.remover( 3 ) );
	}
	
	@Test
	public void testeListarTodos(){
		midiaDAO.listarTodos().forEach( ( m )-> System.out.println( m ));
	}
	
	@Test
	public void testeBuscarPorDataEIdPregador(){
		midiaDAO.buscarPorDataEIdPregador( LocalDate.of(2017, 5, 25) , 1).forEach( m->System.out.println(m) );
	}
	

}
