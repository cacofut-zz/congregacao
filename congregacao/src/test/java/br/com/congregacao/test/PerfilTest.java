package br.com.congregacao.test;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.dao.PerfilDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { DataConfig.class } )
public class PerfilTest {
	
	@Autowired
	private PerfilDAO perfilDAO;

	//@Test
	public void testeListarPorDataEPorIdPregador(){
		System.out.println( perfilDAO.buscarPorDataEIdPregador(LocalDate.of(2017, 5, 25), 1));		
	}
	
	@Test
	public void testeListarTodosPerfis(){
		perfilDAO.listarTodos().forEach( p->System.out.println(p) );
	}
	
	//@Testt
	public void testeBuscarPorId(){
		System.out.println( perfilDAO.buscarPorId( 1 ));
	}
}
