package br.com.congregacao.test;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Estudante;
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
		
	}
	
	//@Test
	public void testeUpdate(){	
		Estudante pregador = new Estudante();

	}
	
	//@Test
	public void testeRemover(){
		System.out.println( pregadorDAO.remover( 3 ));
		
	}
}
