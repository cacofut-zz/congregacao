package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.congregacao.model.TipoMidia;

public class TipoMidiaDAOImpl implements TipoMidiaDAO{
	
	@Autowired
	private JdbcOperations jdbc;
	
	private RowMapper<TipoMidia> rowmapper = ( rs, index )->{ 
		TipoMidia tipoMidia = new TipoMidia( rs.getInt( "id" ), rs.getString( "nome" ) );
		return tipoMidia;
	};

	public List<TipoMidia> listarTodos() {		
		return jdbc.query("select * from tipoMidia", rowmapper );
	}

	public TipoMidia buscarPorId(long id) {
		return jdbc.queryForObject("SELECT * FROM tipoMidia WHERE id = ?", rowmapper, id );
	}

	public TipoMidia inserirOuAtualizar(TipoMidia tipoMidia) {
		long id = tipoMidia.getId();
		if( id == 0 ){
			long novoid = insereTipoMidiaERetornaId(tipoMidia);
			tipoMidia.setId( novoid );
		}
		else{
			jdbc.update( "UPDATE tipoMidia SET nome = ? WHERE id = ?" , tipoMidia.getNome(), id );
		}	
		return tipoMidia;
	}

	public boolean remover( long id ) {		
		return jdbc.update( "DELETE FROM tipoMidia WHERE id = ?" , id ) == 1;
	}
	
	private long insereTipoMidiaERetornaId( TipoMidia tipoMidia ){
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert( (JdbcTemplate)jdbc ).withTableName( "tipoMidia" );
		jdbcInsert.setGeneratedKeyName( "id" );
		Map<String, Object> args = new HashMap<String, Object>();
		args.put( "nome" , tipoMidia.getNome());
		long id = jdbcInsert.executeAndReturnKey(args).longValue();
		return id;
	}
	

	
}
