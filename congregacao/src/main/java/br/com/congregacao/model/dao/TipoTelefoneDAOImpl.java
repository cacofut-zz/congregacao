package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import br.com.congregacao.model.TipoTelefone;

public class TipoTelefoneDAOImpl extends TipoTelefoneDAO{

	private RowMapper<TipoTelefone> rowMapper = (rs, index)->{
		TipoTelefone tipo = new TipoTelefone();
		tipo.setId  ( rs.getLong  ( "tipo_telefone_id"  ));
		tipo.setNome( rs.getString( "tipo_telefone_nome"));
		return tipo;
		
	};
	
	@Override
	public Map<String, Object> getArgs(TipoTelefone tipoTelefone) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("tipo_telefone_nome", tipoTelefone.getNome());
		return args;
	}

	@Override
	public String getCampoId() {
		return "tipo_telefone_id";
	}

	@Override
	public String getTableName() {
		return "tipo_telefone";
	}

	@Override
	public String getCampos() {
		return "tipo_telefone_id, tipo_telefone_nome";
	}

	@Override
	public String getCamposUpdate() {
		return "tipo_telefone_nome = ?";
	}

	@Override
	public Object[] getCamposValueUpdate(TipoTelefone tipoTelefone) {
		return new Object[]{ tipoTelefone.getNome(), tipoTelefone.getId() };
	}

	@Override
	public RowMapper<TipoTelefone> getRowMapper() {
		return rowMapper;
	}

}
