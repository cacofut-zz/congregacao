package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.congregacao.model.Pais;


public class PaisDAOImpl extends PaisDAO{

	private RowMapper<Pais> rowMapper = ( rs, index ) -> {
		Pais pais = new Pais();
		pais.setId   ( rs.getLong( "pais_id" ) );
		pais.setNome ( rs.getString( "pais_nome" ) );
		pais.setSigla( rs.getString( "pais_sigla" ) );
		return pais;
	};
		
	@Override
	public String getCampoId() {		
		return "pais_id";
	}

	@Override
	public String getTableName() {
		return "pais";
	}

	@Override
	public Map<String, Object> getArgs( Pais pais ) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put( "pais_nome", pais.getNome());
		args.put( "pais_sigla", pais.getSigla());
		return args;
	}

	@Override
	public String getCampos() {		
		return "pais_id, pais_nome, pais_sigla";
	}

	@Override
	public RowMapper<Pais> getRowMapper() {
		return rowMapper;
	}

	@Override
	public String getCamposUpdate() {
		return "pais_nome = ?, pais_sigla = ?";
	}

	@Override
	public Object[] getCamposValueUpdate(Pais pais) {		
		return new Object[]{ pais.getNome(), pais.getSigla(), pais.getId() };
	}


}
