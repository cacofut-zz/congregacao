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
import br.com.congregacao.model.dao.EstadoDAO;
import br.com.congregacao.model.dao.EstadoDAOImpl;
import br.com.congregacao.model.dao.PaisDAO;
import br.com.congregacao.model.dao.PaisDAOImpl;
import br.com.congregacao.model.dao.PerfilDAO;
import br.com.congregacao.model.dao.PerfilDAOImpl;
import br.com.congregacao.model.dao.PregadorDAO;
import br.com.congregacao.model.dao.PregadorDAOImpl;
import br.com.congregacao.model.dao.RevisitaDAO;
import br.com.congregacao.model.dao.RevisitaDAOImpl;
import br.com.congregacao.model.dao.TelefonePregadorDAO;
import br.com.congregacao.model.dao.TelefonePregadorDAOImpl;
import br.com.congregacao.model.dao.TipoPregadorDAO;
import br.com.congregacao.model.dao.TipoPregadorDAOImpl;
import br.com.congregacao.model.dao.TipoTelefoneDAO;
import br.com.congregacao.model.dao.TipoTelefoneDAOImpl;


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
	public PregadorDAO pregadorDAO(){
		return new PregadorDAOImpl();
	}
	
	@Bean
	public ArquivoDAO arquivoDAO(){
		return new ArquivoDAOImpl();
	}
		
	@Bean
	public RevisitaDAO revisitaDAO(){
		return new RevisitaDAOImpl();
	}
	
	@Bean
	public PerfilDAO perfilDAO(){
		return new PerfilDAOImpl();
	}
	
	@Bean
	public PaisDAO paisDAO(){
		return new PaisDAOImpl();
	}
	
	@Bean
	public EstadoDAO estadoDAO(){
		return new EstadoDAOImpl();
	}
	
	@Bean
	public TipoPregadorDAO tipoPregadorDAO(){
		return new TipoPregadorDAOImpl();
	}
	
	@Bean
	public TipoTelefoneDAO tipoTelefoneDAO(){
		return new TipoTelefoneDAOImpl();
	}
	
	@Bean
	public TelefonePregadorDAO telefonePregadorDAO(){
		return new TelefonePregadorDAOImpl();
	}
}
