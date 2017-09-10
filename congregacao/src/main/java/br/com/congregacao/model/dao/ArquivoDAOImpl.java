package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Estudante;

public class ArquivoDAOImpl implements ArquivoDAO{

	@Autowired
	private JdbcOperations jdbc;
	
	private RowMapper<Arquivo> rowMapper = ( rs, index )->{
		Arquivo arquivo = new Arquivo();
		arquivo.setId       ( rs.getLong  ( "id" ) );
		arquivo.setNome     ( rs.getString( "nome" ) );
		arquivo.setDiretorio( rs.getString( "diretorio" ) );
		arquivo.setExtencao ( rs.getString( "extencao" ) );
		return arquivo;
		
	};
	
	@Override
	public List<Arquivo> listarTodos() {
		return jdbc.query( "SELECT * FROM arquivo", rowMapper );
	}

	@Override
	public Arquivo buscarPorId(long id) {
		return jdbc.queryForObject( "SELECT * FROM arquivo WHERE id = ?" , rowMapper, id );
	}

	@Override
	public Arquivo inserirOuAtualizar(Arquivo arquivo) {
		long id = arquivo.getId();
		if( id == 0 ){
			long novoId = insereArquivoERetornaId(arquivo);
			arquivo.setId(novoId);
		}
		else{
			jdbc.update( "UPDATE arquivo SET "
				+ "nome      = ?, "
				+ "diretorio = ?, "
				+ "extencao  = ? "
				+ "where id  = ?",
				arquivo.getNome(),
				arquivo.getDiretorio(),
				arquivo.getExtencao(),
				id
			);
		}
		// TODO Auto-generated method stub
		return arquivo;
	}

	@Override
	public boolean remover(long id) {		
		return jdbc.update( "DELETE FROM arquivo where id = ? ", id ) == 1;
	}
	
	private long insereArquivoERetornaId( Arquivo arquivo ){
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert( (JdbcTemplate)jdbc ).withTableName( "arquivo" );
		jdbcInsert.setGeneratedKeyName( "id" );
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("nome",      arquivo.getNome());
		args.put("diretorio", arquivo.getDiretorio());
		args.put("extencao",  arquivo.getExtencao());
		
		long id = jdbcInsert.executeAndReturnKey(args).longValue();
		return id;
		
	}
	
	
}
