package br.com.congregacao.configuracao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.congregacao.model.dao.ArquivoDAO;
import br.com.congregacao.model.dao.ArquivoDAOImpl;
import br.com.congregacao.model.dao.MidiaDAO;
import br.com.congregacao.model.dao.MidiaDAOImpl;
import br.com.congregacao.model.dao.PerfilDAO;
import br.com.congregacao.model.dao.PerfilDAOImpl;
import br.com.congregacao.model.dao.PregadorDAO;
import br.com.congregacao.model.dao.PregadorDAOImpl;
import br.com.congregacao.model.dao.RevisitaDAO;
import br.com.congregacao.model.dao.RevisitaDAOImpl;
import br.com.congregacao.model.dao.TipoMidiaDAO;
import br.com.congregacao.model.dao.TipoMidiaDAOImpl;

@Configuration
@ComponentScan("br.com.congregacao.dao")
public class DataConfig {

	@Bean
	public DataSource dataSourceDevelopment() throws SQLException{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
		dataSource.setUrl( "jdbc:mysql://localhost:3306/congregacao" );
		dataSource.setUsername( "cristiano" );
		dataSource.setPassword( "41042075-x" );
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate( DataSource dataSource ){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public PlatformTransactionManager transactionManager( DataSource dataSource ){
		return new DataSourceTransactionManager( dataSource );
	}
	
	@Bean
	public TipoMidiaDAO tipoMidiaDAO(){
		return new TipoMidiaDAOImpl();
	}
	
	@Bean
	public PregadorDAO pregadorDAO(){
		return new PregadorDAOImpl();
	}
	
	@Bean
	public ArquivoDAO arquivoDAO(){
		return new ArquivoDAOImpl();
	}
	
	@Bean
	public MidiaDAO midiaDAO(){
		return new MidiaDAOImpl();
	}
	
	@Bean
	public RevisitaDAO revisitaDAO(){
		return new RevisitaDAOImpl();
	}
	
	@Bean
	public PerfilDAO perfilDAO(){
		return new PerfilDAOImpl();
	}
}
