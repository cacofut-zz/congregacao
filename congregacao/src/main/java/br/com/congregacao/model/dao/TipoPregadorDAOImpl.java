package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

import br.com.congregacao.model.TipoPregador;

public class TipoPregadorDAOImpl extends TipoPregadorDAO{

	private RowMapper<TipoPregador> rowMappper = (rs, index)->{
		TipoPregador tipoPregador = new TipoPregador();
		tipoPregador.setId  (rs.getLong  ( "tipo_pregador_id"  ));
		tipoPregador.setNome(rs.getString( "tipo_pregador_nome"));
		return tipoPregador;
	};

	@Override
	public Map<String, Object> getArgs(TipoPregador tipoPregador) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("tipo_pregador_nome" , tipoPregador.getNome() );
		return args;
	}

	@Override
	public String getCampoId() {
		return "tipo_pregador_id";
	}

	@Override
	public String getTableName() {
		return "tipo_pregador";
	}

	@Override
	public String getCampos() {
		return "tipo_pregador_id, tipo_pregador_nome";
	}

	@Override
	public RowMapper<TipoPregador> getRowMapper() {
		return rowMappper;
	}

	@Override
	public String getCamposUpdate() {
		return "tipo_pregador_nome = ?";
	}

	@Override
	public Object[] getCamposValueUpdate(TipoPregador tipoPregador) {
		return new Object[]{ tipoPregador.getNome(), tipoPregador.getId() };
	}

}
