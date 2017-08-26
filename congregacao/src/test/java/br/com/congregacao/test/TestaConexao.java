package br.com.congregacao.test;

import static org.junit.Assert.*;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.congregacao.configuracao.DataConfig;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = DataConfig.class )
public class TestaConexao {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConection(){
		assertNotNull( dataSource );
	}
}
