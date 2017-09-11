package br.com.congregacao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;
import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Pregador;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataConfig.class})
public class PregadorTeste {

	@Test
	public void deveRetornarNull(){
		Pregador pregador = new Pregador();
		assertEquals( null ,pregador.getIdDoArquivoOuRetorneNull());
	}
	
	@Test
	public void deveRetornarOIdDoArquivo(){
		Pregador pregador = new Pregador();
		pregador.setImagem( new Arquivo(2) );
		assertEquals( new Long(2) ,pregador.getIdDoArquivoOuRetorneNull());
	}
	
}
