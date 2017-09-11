package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import br.com.congregacao.model.TelefonePregador;
import br.com.congregacao.model.TipoTelefone;

public class TelefonePregadorDAOImpl extends TelefonePregadorDAO{
	
	@Autowired
	private TipoTelefoneDAO tipoTelefoneDAO;

	private RowMapper<TelefonePregador> rowMapper = (rs, index)->{
		
		TelefonePregador telefone = new TelefonePregador();
		telefone.setId        (rs.getLong  ("telefone_pregador_id"));
		telefone.setNumero    (rs.getString("telefone_pregador_numero"));
		telefone.setPregadorId(rs.getLong  ("telefone_pregador_pregador_id" ) );
		
		TipoTelefone tipoTelefone = tipoTelefoneDAO.buscarPorId( rs.getLong( "telefone_pregador_tipo_telefone_id" ));
		telefone.setTipoTelefone( tipoTelefone );
		
		return telefone;
	}; 
	
	@Override
	public Map<String, Object> getArgs(TelefonePregador telefonePregador) {
		Map<String, Object> args = new HashMap<>();
		args.put( "telefone_pregador_numero", telefonePregador.getNumero());
		args.put( "telefone_pregador_pregador_id", telefonePregador.getPregadorId());
		args.put( "telefone_pregador_tipo_telefone_id", telefonePregador.getTipoTelefone().getId());
		return args;
	}

	@Override
	public String getCampoId() {
		return "telefone_pregador_id";
	}

	@Override
	public String getTableName() {
		return "telefone_pregador";
	}

	@Override
	public String getCampos() {
		return 
		"telefone_pregador_id, "
		+ "telefone_pregador_numero, "
		+ "telefone_pregador_pregador_id, "
		+ "telefone_pregador_tipo_telefone_id";
	}

	@Override
	public String getCamposUpdate() {		
		return 
		"telefone_pregador_numero = ?,"
		+ "telefone_pregador_pregador_id = ?,"
		+ "telefone_pregador_tipo_telefone_id = ?";
	}

	@Override
	public Object[] getCamposValueUpdate(TelefonePregador telefonePregador) {
		return new Object[]{ 
			telefonePregador.getNumero(), 
			telefonePregador.getPregadorId(),
			telefonePregador.getTipoTelefone().getId(),
			telefonePregador.getId()
		};
	}

	@Override
	public RowMapper<TelefonePregador> getRowMapper() {
		return rowMapper;
	}

}
