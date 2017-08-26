package br.com.congregacao.model.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import br.com.congregacao.model.Revisita;

public class RevisitaDAOImpl implements RevisitaDAO{

	@Autowired
	private JdbcOperations jdbc;
	private RowMapper<Revisita> rowMapper = ( rs, index ) ->{
		Revisita revisita = new Revisita();
		revisita.setId         ( rs.getLong  ( "revisita_id" ) );
		revisita.setEndereco   ( rs.getString( "revisita_endereco" ) );
		revisita.setNome       ( rs.getString( "revisita_nome" ) );
		revisita.setObservacoes( rs.getString( "revisita_observacoes" ) );
		revisita.setPerfilData ( rs.getDate  ( "revisita_perfil_data" ).toLocalDate() );
		revisita.setPerfilPregadorId( rs.getLong( "revisita_perfil_pregador_id" ) );
		
		return revisita;
	};
	
	@Override
	public List<Revisita> listarTodos() {
		return jdbc.query( 
			"SELECT "
			+ "revisita_id, "
			+ "revisita_endereco, "
			+ "revisita_nome, "
			+ "revisita_observacoes, "
			+ "revisita_perfil_data, "
			+ "revisita_perfil_pregador_id "
			+ "FROM revisita" , rowMapper );
	}

	@Override
	public Revisita buscarPorId(long id) {
		return jdbc.queryForObject( 
		    "SELECT "
			+ "revisita_id, "
			+ "revisita_endereco, "
			+ "revisita_nome, "
			+ "revisita_observacoes, "
			+ "revisita_perfil_data, "
			+ "revisita_perfil_pregador_id "
			+ "FROM revisita "
			+ "WHERE revisita_id = ?" , rowMapper, id );
	}
	
	@Override
	public List<Revisita> buscarPorDataEIdPregador(LocalDate data, long idPregador) {
		return jdbc.query( 
		"SELECT "
		+ "revisita_id, "
		+ "revisita_endereco, "
		+ "revisita_nome, "
		+ "revisita_observacoes, "
		+ "revisita_perfil_data, "
		+ "revisita_perfil_pregador_id "
		+ "FROM revisita "
		+ "WHERE revisita_perfil_data        = ? "
		+ "  AND revisita_perfil_pregador_id = ?" , rowMapper, new Object[]{ Date.valueOf( data ), idPregador } );
	}

	@Override
	public Revisita inserirOuAtualizar(Revisita revisita) {
		long id = revisita.getId();
		if( id == 0 ){
			revisita.setId( insereRevisitaERetornaId(revisita) );
		}
		else{
			jdbc.update( 
				"UPDATE revisita SET "
				+ "revisita_endereco    = ?, "
				+ "revisita_nome        = ?, "
				+ "revisita_observacoes = ? "
				+ "WHERE revisita_id    = ?",
				revisita.getEndereco(),
				revisita.getNome(),
				revisita.getObservacoes(),				
				id 
			);
		}
		return revisita;
	}

	@Override
	public boolean remover(long id) {
		return jdbc.update( "DELETE FROM revisita WHERE revisita_id = ?", id ) == 1;
	}
	
	
	private long insereRevisitaERetornaId( Revisita revisita ){
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert( ( JdbcTemplate )jdbc ).withTableName( "revisita" );
		jdbcInsert.setGeneratedKeyName( "revisita_id" );
		Map<String, Object> args = new HashMap<String, Object>();
		args.put( "revisita_endereco" , revisita.getEndereco());
		args.put( "revisita_nome" , revisita.getNome());
		args.put( "revisita_observacoes" , revisita.getObservacoes());
		args.put( "revisita_perfil_data" , Date.valueOf( revisita.getPerfilData()));
		args.put( "revisita_perfil_pregador_id" , revisita.getPerfilPregadorId());
		return jdbcInsert.executeAndReturnKey(args).longValue();
	}



}
