package br.com.congregacao.test;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Pregador;
import br.com.congregacao.model.TipoPregador;
import br.com.congregacao.model.dao.PregadorDAO;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = DataConfig.class )
public class PregadorTest {

	@Autowired
	private PregadorDAO pregadorDAO;
	
	@Test
	public void testeListarTodos(){
		pregadorDAO.listarTodos().forEach( ( p ) -> System.out.println( p ) );
	}
	
	@Test
	public void listarPorId(){
		System.out.println( pregadorDAO.buscarPorId(2) );
	}
	
	//@Test
	public void testeInsert(){		
		Pregador pregador = new Pregador();
		pregador.setNome    ( "cristiano d fgdfg d" );
		pregador.setEmail   ( "cacofut@hotmail.com" );
		pregador.setTelefone( "991874268" );
		//pregador.setEndereco( "Rua Ernest Renam 954" );
		pregador.setTipoPregador( new TipoPregador(1) );
		pregador.setImagem  ( new Arquivo(1) );
		pregador.setDataNascimento( LocalDate.of(1987, 1, 28));		
		pregadorDAO.inserirOuAtualizar( pregador );
	}
	
	//@Test
	public void testeUpdate(){	
		Pregador pregador = new Pregador();
		pregador.setId      ( 4 );
		pregador.setNome    ( "cristiano carvalho amaral" );
		pregador.setEmail   ( "cacofut@hotmail.com" );
		pregador.setTelefone( "991874268" );
		//pregador.setEndereco( "Rua Ernest Renam 954" );
		pregador.setImagem  ( null );
		pregador.setDataNascimento( LocalDate.of(1987, 1, 28));		
		pregadorDAO.inserirOuAtualizar( pregador );
	}
	
	//@Test
	public void testeRemover(){
		System.out.println( pregadorDAO.remover( 3 ));
		
	}
}
