package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import br.com.congregacao.model.Estado;

public class EstadoDAOImpl extends EstadoDAO{

	private RowMapper<Estado> rowMapper = ( rs, index ) ->{
		Estado estado = new Estado();
		estado.setId   ( rs.getLong  ( "estado_id"   ));
		estado.setNome ( rs.getString( "estado_nome" ));
		estado.setSigla( rs.getString( "estado_sigla"));
		return estado;
	};
	
	@Override
	public Map<String, Object> getArgs(Estado estado) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put( "estado_nome",  estado.getNome());
		args.put( "estado_sigla", estado.getSigla());
		return args;
	}

	@Override
	public String getCampoId() {
		return "estado_id";
	}

	@Override
	public String getTableName() {
		return "estado";
	}

	@Override
	public String getCampos() {
		return "estado_id, estado_nome, estado_sigla";
	}

	@Override
	public RowMapper<Estado> getRowMapper() {
		return rowMapper;
	}

	@Override
	public String getCamposUpdate() {
		return "estado_nome = ?, estado_sigla = ?";
	}

	@Override
	public Object[] getCamposValueUpdate(Estado estado) {
		return new Object[]{ estado.getNome(), estado.getSigla(), estado.getId() };
	}


}
