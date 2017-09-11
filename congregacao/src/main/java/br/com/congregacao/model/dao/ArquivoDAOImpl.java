package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Estudante;

public class ArquivoDAOImpl extends ArquivoDAO{
	
	private RowMapper<Arquivo> rowMapper = ( rs, index )->{
		
		Arquivo arquivo = new Arquivo();
		arquivo.setId       ( rs.getLong  ( "arquivo_id" ));
		arquivo.setNome     ( rs.getString( "arquivo_nome" ));
		arquivo.setDiretorio( rs.getString( "arquivo_diretorio" ));
		arquivo.setExtencao ( rs.getString( "arquivo_extencao" ));
		return arquivo;
		
	};
	
	@Override
	public Map<String, Object> getArgs(Arquivo arquivo) {
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("arquivo_nome",      arquivo.getNome());
		args.put("arquivo_diretorio", arquivo.getDiretorio());
		args.put("arquivo_extencao",  arquivo.getExtencao());
		return args;
		
	}
	
	public Arquivo buscarPorId(long id) {
		try{return super.buscarPorId(id);}
		catch( EmptyResultDataAccessException ex ){return new Arquivo();}	
	}

	@Override
	public String getCampoId() {
		return "arquivo_id";
	}

	@Override
	public String getTableName() {
		return "arquivo";
	}

	@Override
	public String getCampos() {
		return "arquivo_id, arquivo_nome, arquivo_diretorio, arquivo_extencao";
	}

	@Override
	public String getCamposUpdate() {
		return "arquivo_nome = ?, arquivo_diretorio  = ?, arquivo_extencao = ?";
	}

	@Override
	public Object[] getCamposValueUpdate(Arquivo arquivo) {
		return new Object[]{ arquivo.getNome(), arquivo.getDiretorio(), arquivo.getExtencao(), arquivo.getId() };
	}

	@Override
	public RowMapper<Arquivo> getRowMapper() {
		return rowMapper;
	}
	
	
}
