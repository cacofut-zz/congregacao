package br.com.congregacao.model.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.congregacao.model.Estado;
import br.com.congregacao.model.TipoPregador;

public abstract class JdbcDAO<T extends ObjectDomain> implements DAO<T> {
	
	@Autowired
	private JdbcOperations jdbc;
	
	protected long insereERetornaId( T objeto ){	
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert( ( JdbcTemplate )jdbc ).withTableName( getTableName() );
		jdbcInsert.setGeneratedKeyName( getCampoId() );
		return jdbcInsert.executeAndReturnKey(getArgs(objeto)).longValue();	
	}	
	
	public T inserirOuAtualizar( T objeto ) {
		long id = objeto.getId();
		if( id == 0 ){
			objeto.setId( insereERetornaId(objeto) );
		}
		else{
			jdbc
			.update("UPDATE "+ getTableName() +" SET "+ getCamposUpdate() +" WHERE "+ getCampoId() +" = ?", getCamposValueUpdate(objeto));
		}
		return objeto;
	}
	
	public boolean removerTodos() {
		return jdbc.update( "DELETE FROM "+ getTableName() +" WHERE "+ getCampoId() +" > ?", 0 ) >= 1;
	}
	
	public boolean remover(long id) {		
		return jdbc.update( "DELETE FROM "+ getTableName() +" WHERE "+ getCampoId() +" = ?", id ) >= 1;
	}
	
	public List<T> listarTodos() {
		return getJdbc().query( "SELECT "+ getCampos() +" FROM " +getTableName() , getRowMapper());
	}
	
	public T buscarPorId(long id) {
		return jdbc.queryForObject("SELECT "+ getCampos() +" FROM "+ getTableName() +" WHERE "+ getCampoId() +" = ?", 
				new Object[]{id}, getRowMapper());
	}

	public abstract Map<String, Object> getArgs( T objeto );
	public abstract String getCampoId();
	public abstract String getTableName();
	public abstract String getCampos();
	public abstract String getCamposUpdate();
	public abstract Object[] getCamposValueUpdate( T objeto );
	public abstract RowMapper<T> getRowMapper();

	public JdbcOperations getJdbc() {
		return jdbc;
	}
	
	
}
