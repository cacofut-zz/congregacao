package br.com.congregacao.model.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.reflect.IReflectionWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Midia;
import br.com.congregacao.model.TipoMidia;

public class MidiaDAOImpl implements MidiaDAO{

	@Autowired
	private JdbcOperations jdbc;
	private RowMapper<Midia> rowMapper = ( rs, index )->{
		
		Midia midia = new Midia();
		midia.setId        ( rs.getLong   ( "midia_id" ) );
		midia.setTitulo    ( rs.getString ( "midia_titulo" ) );
		midia.setQuantidade( rs.getInt    ( "midia_quantidade" ) );
		midia.setPerfilData( rs.getDate   ( "midia_perfil_data" ).toLocalDate() );
		midia.setTipoMidia ( new TipoMidia( rs.getLong( "tipo_midia_id" ), rs.getString( "tipo_midia_nome" ) ) );
		midia.setPregadorId( rs.getLong( "midia_perfil_pregador_id" ) );
		
		
		long arquivo_id = rs.getLong( "arquivo_id" );
		Arquivo arquivo = new Arquivo();
		if( arquivo_id != 0 ){
			arquivo.setId       ( rs.getLong  ( "arquivo_id"  ));
			arquivo.setNome     ( rs.getString( "arquivo_nome" ));
			arquivo.setDiretorio( rs.getString( "arquivo_diretorio"   ));
			arquivo.setExtencao ( rs.getString( "arquivo_extencao"    ));
		}
		
		midia.setImagem( arquivo );
		return midia;
	};
	
	@Override
	public List<Midia> listarTodos() {
		return jdbc.query(
		"SELECT * FROM( "
		+"	  SELECT * FROM midia, tipo_midia "
		+ "     WHERE tipo_midia_id = midia_id "
		+") a " 
		+" LEFT JOIN arquivo b ON midia_arquivo_id = arquivo_id", rowMapper);
	}

	@Override
	public Midia buscarPorId(long id) {		
		return jdbc.queryForObject(
		"SELECT * FROM( "
		+"	  SELECT * FROM midia, tipo_midia "
		+ "     WHERE midia_id = ? "
		+ "       AND tipo_midia_id = midia_id"
		+") a " 
		+" LEFT JOIN arquivo b ON midia_arquivo_id = arquivo_id", rowMapper, id);	
	}
	
	@Override
	public List<Midia> buscarPorDataEIdPregador(LocalDate data, long idPregador) {
		
		return jdbc.query(
		"SELECT * FROM( "
		+"	  SELECT * FROM midia, tipo_midia "
		+ "		WHERE midia_perfil_data = ? "
		+ "       AND midia_perfil_pregador_id = ? "
		+ "       AND tipo_midia_id = midia_id "
		+") a " 
		+" LEFT JOIN arquivo b ON midia_arquivo_id = arquivo_id", rowMapper, new Object[]{ Date.valueOf(data), idPregador } );
		
		
	}

	@Override
	public Midia inserirOuAtualizar(Midia midia){
		long id = midia.getId();
		if( id == 0 ){
			midia.setId( insereMidiaERetornaId(midia) );
		}
		else{
			
			long arquivo_id = midia.getImagem().getId();
			jdbc.update( 
				"UPDATE midia SET "
				+ "midia_titulo        = ?, "
				+ "midia_quantidade    = ?, "
				+ "midia_tipo_midia_id = ?, "
				+ "midia_arquivo_id    = ?  "
				+ "WHERE midia_id      = ?  ",
				midia.getTitulo(), 
				midia.getQuantidade(), 
				midia.getTipoMidia().getId(), 
				arquivo_id == 0 ? null : arquivo_id,
				id 
			);
		}
		return midia;
	}

	@Override
	public boolean remover(long id) {
		return jdbc.update( "DELETE FROM midia WHERE midia_id = ?", id ) == 1;
	}

	
	private long insereMidiaERetornaId( Midia midia ){
		
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(( JdbcTemplate )jdbc).withTableName( "midia" );
		jdbcInsert.setGeneratedKeyName( "midia_id" );
		
		long arquivo_id = midia.getImagem().getId();
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put( "midia_titulo" ,       midia.getTitulo() );
		args.put( "midia_quantidade" ,   midia.getQuantidade() );
		args.put( "midia_tipo_midia_id", midia.getTipoMidia().getId() );
		args.put( "midia_arquivo_id",    arquivo_id == 0 ? null : arquivo_id );
		args.put( "midia_perfil_data",   java.sql.Date.valueOf( midia.getPerfilData()));
		args.put( "midia_perfil_pregador_id",  midia.getPregadorId() );
				
		return jdbcInsert.executeAndReturnKey(args).longValue();
		
	}

	
}
