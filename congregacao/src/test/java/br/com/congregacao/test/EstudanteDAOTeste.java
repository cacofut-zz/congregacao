package br.com.congregacao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Estado;
import br.com.congregacao.model.Estudante;
import br.com.congregacao.model.Pais;
import br.com.congregacao.model.Pregador;
import br.com.congregacao.model.dao.EstudanteDAO;
import static org.junit.Assert.*;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = DataConfig.class )
public class EstudanteDAOTeste {
	
	@Autowired
	private EstudanteDAO estudanteDAO;
	
	@Before
	public void inicializar(){
		System.out.println( "Limpar tabela" );
		estudanteDAO.removerTodos();
	}
	
	@Test
	public void tabelaDeveEstarVazia(){
		assertEquals( 0 , estudanteDAO.listarTodos().size());
	}
	
	@Test
	public void deveInserirUmEstudante(){
		inserirUmEstudante();
		assertEquals(1, estudanteDAO.listarTodos().size());
	}
	
	@Test
	public void deveAtualizarUmEstudante(){
		Estudante atualizar = estudanteDAO.buscarPorId( inserirUmEstudante().getId());
		atualizar.setNome( "cristiano222" );
		atualizar.setSobrenome( "carvalho amaral2222" );
		atualizar.setNumero( "954222" );
		atualizar.setComplemento( "bloco 1 apt 2012222" );
		atualizar.setLogradouro( "rua ernest renam2222" );
		atualizar.setCep( "0565902022" );
		atualizar.setBairro( "Paraisópolis2222");
		atualizar.setImagem( null );
		atualizar.setPais( new Pais(2) );
		atualizar.setEstado( new Estado(2) );
		Estudante atualizado = estudanteDAO.buscarPorId(estudanteDAO.inserirOuAtualizar( atualizar ).getId());
		assertEquals( "cristiano222", atualizado.getNome() );

	}
	
	@Test
	public void deveRemoverUmEstudante(){
		assertEquals(true, estudanteDAO.remover(inserirUmEstudante().getId()));
	}
	
	@Test
	public void listarTodos(){
		inserirUmEstudante();
		estudanteDAO.listarTodos().forEach((estudante)->System.out.println(estudante));
	}
	
	private Estudante inserirUmEstudante(){
		Estudante estudante = new Estudante();
		estudante.setNome( "joao" );
		estudante.setSobrenome( "da silva sauro" );
		estudante.setImagem( new Arquivo() );
		estudante.setNumero( "123" );
		estudante.setComplemento("viela 456");
		estudante.setLogradouro("rua dos popas");
		estudante.setBairro( "paraisopolis" );
		estudante.setCep("05659-020");
		estudante.setPais(new Pais(1));
		estudante.setEstado(new Estado(1));
		estudante.setPregadorId(31);
		
		estudanteDAO.inserirOuAtualizar(estudante);
		return estudante;
	}
	
}
