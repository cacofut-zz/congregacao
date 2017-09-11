package br.com.congregacao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.TipoTelefone;
import br.com.congregacao.model.dao.TipoTelefoneDAO;
import static org.junit.Assert.*;

import org.junit.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = { DataConfig.class } )
public class TipoTelefoneDAOTeste {

	@Autowired
	private TipoTelefoneDAO dao;
	
	@Before
	public void inicializar(){
		System.out.println( "Limpando a tabela" );
		dao.removerTodos();
	}
	
	@Test
	public void tabelaDeveEstarVazia(){
		assertEquals( 0 , dao.listarTodos().size());
	}
	
	@Test
	public void deveInserirUmTipoTelefone(){
		inserirUmTipoTelefone();
		assertEquals( 1 , dao.listarTodos().size());
	}
	
	@Test
	public void deveAtualizarUmTipoTelefone(){
		TipoTelefone salvo = inserirUmTipoTelefone();
		TipoTelefone atualizar = dao.buscarPorId( salvo.getId());
		atualizar.setNome( "comercial" );
		dao.inserirOuAtualizar( atualizar );
		assertEquals( "comercial" , atualizar.getNome());
	}
	
	@Test
	public void deveRemoverUmTipoTelefone(){
		boolean removeu = dao.remover( inserirUmTipoTelefone().getId());
		assertEquals( true , removeu );
	}
	
	private TipoTelefone inserirUmTipoTelefone(){
		TipoTelefone tipoTelefone = new TipoTelefone( "residencial" );
		dao.inserirOuAtualizar(tipoTelefone);
		return tipoTelefone;
	}
}
