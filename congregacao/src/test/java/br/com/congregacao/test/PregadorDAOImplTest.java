package br.com.congregacao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Estado;
import br.com.congregacao.model.Pais;
import br.com.congregacao.model.Pregador;
import br.com.congregacao.model.TipoPregador;
import br.com.congregacao.model.dao.PregadorDAO;
import static org.junit.Assert.*;

import java.time.LocalDate;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = DataConfig.class )
public class PregadorDAOImplTest {

	@Autowired
	private PregadorDAO dao;
	
	@Before
	public void inicializar(){
		System.out.println( "Limpar tabela" );
		dao.removerTodos();
	}
	
	@Test
	public void tabelaDeveEstarVazia(){
		assertEquals(0, dao.listarTodos().size());
	}
	
	@Test
	public void deveInserirUmPregador(){
		inserirUmPRegador();
		assertEquals( 1, dao.listarTodos().size() );
	}
	
	@Test
	public void deveAtualizarUmPregador(){
		Pregador atualizar = dao.buscarPorId( inserirUmPRegador().getId());
		atualizar.setNome( "cristiano222" );
		atualizar.setSobrenome( "carvalho amaral2222" );
		atualizar.setDataNascimento( LocalDate.of(1987, 1, 29) );
		atualizar.setEmail( "cacofut@hotmail.com2222" );
		atualizar.setNumero( "954222" );
		atualizar.setComplemento( "bloco 1 apt 2012222" );
		atualizar.setLogradouro( "rua ernest renam2222" );
		atualizar.setCep( "0565902022" );
		atualizar.setBairro( "Paraisópolis2222");
		atualizar.setImagem( null );
		atualizar.setPais( new Pais(2) );
		atualizar.setEstado( new Estado(2) );
		Pregador atualizado = dao.buscarPorId(dao.inserirOuAtualizar( atualizar ).getId());
		assertEquals( "cristiano222", atualizado.getNome() );

	}
	
	@Test
	public void deveRemoverUmPregador(){
		assertEquals( true , dao.remover( inserirUmPRegador().getId()));
	}
	
	private Pregador inserirUmPRegador(){
		Pregador pregador = new Pregador();
		pregador.setNome( "cristiano" );
		pregador.setSobrenome( "carvalho amaral" );
		pregador.setDataNascimento( LocalDate.of(1987, 1, 28) );
		pregador.setEmail( "cacofut@hotmail.com" );
		pregador.setStatus( true );
		pregador.setNumero( "954" );
		pregador.setComplemento( "bloco 1 apt 201" );
		pregador.setLogradouro( "rua ernest renam" );
		pregador.setCep( "05659020" );
		pregador.setBairro( "Paraisópolis");
		pregador.setImagem( null );
		pregador.setTipoPregador( new TipoPregador(1));
		pregador.setPais( new Pais(1) );
		pregador.setEstado( new Estado(1) );
		dao.inserirOuAtualizar( pregador );
		
		return pregador;
		
	}
}
