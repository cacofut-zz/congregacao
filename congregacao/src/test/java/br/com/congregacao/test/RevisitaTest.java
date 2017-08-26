package br.com.congregacao.test;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Revisita;
import br.com.congregacao.model.dao.RevisitaDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { DataConfig.class } )
public class RevisitaTest {

	@Autowired
	private RevisitaDAO revisitaDAO;
	

	@Test
	public void testeAtualizar(){
		Revisita revisita = new Revisita( 4 );
		revisita.setEndereco( "Rua das treze horas 954 atualizada" );
		revisita.setNome( "Lurdes da silva atualizada " );
		revisita.setObservacoes( "Esta visita foi muito encorajadora atualizada" );
		revisita.setPerfilData( LocalDate.of(2017, 5, 25) );
		revisita.setPerfilPregadorId( 1 );
		revisitaDAO.inserirOuAtualizar( revisita );
		
	}
	
	//@Test
	public void testeInsert(){
		Revisita revisita = new Revisita();
		revisita.setEndereco( "Rua das treze horas 954" );
		revisita.setNome( "Lurdes da silva" );
		revisita.setObservacoes( "Esta visita foi muito encorajadora" );
		revisita.setPerfilData( LocalDate.of(2017, 5, 25) );
		revisita.setPerfilPregadorId( 1 );
		revisitaDAO.inserirOuAtualizar( revisita );
		
	}
	
	
	
	//@Test
	public void testeRemover(){
		System.out.println( revisitaDAO.remover( 3 ) );
	}
	
	//@Test
	public void testeBuscarPorId(){
		System.out.println( revisitaDAO.buscarPorId( 3 ) );
	}
	
	//@Test
	public void testeListarTodos(){
		revisitaDAO.listarTodos().forEach( r->System.out.println(r) );
	}
}
