package br.com.congregacao.model.dao;

import java.time.LocalDate;
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
import br.com.congregacao.model.Pregador;

import br.com.congregacao.model.TipoPregador;

public class PregadorDAOImpl implements PregadorDAO{

	@Autowired
	private JdbcOperations jdbc;
	
	private RowMapper<Pregador> rowMapper = ( rs, index ) ->{
		
		long arquivo_id   = rs.getLong( "pregador_arquivo_id" );
		Pregador pregador = new Pregador();
		Arquivo arquivo   = new Arquivo();
		
		if( arquivo_id != 0 ){
			arquivo.setId       ( arquivo_id );
			arquivo.setNome     ( rs.getString( "arquivo_nome" ));
			arquivo.setDiretorio( rs.getString( "arquivo_diretorio" ));
			arquivo.setExtencao ( rs.getString( "arquivo_extencao" ));
		}
				
		pregador.setId          ( rs.getLong   ( "pregador_id" ) );
		pregador.setNome        ( rs.getString ( "pregador_nome" ) );
		pregador.setEmail       ( rs.getString ( "pregador_email" ) );
		//pregador.setTelefone    ( rs.getString ( "pregador_telefone" ) );
		//pregador.setEndereco    ( rs.getString ( "pregador_endereco" ) );
		pregador.setStatus      ( rs.getBoolean( "pregador_status" ) );
		pregador.setImagem      ( arquivo );
		pregador.setTipoPregador( new TipoPregador( rs.getLong( "tipo_pregador_id" ), rs.getString( "tipo_pregador_nome" )));
		pregador.setDataNascimento( rs.getDate( "pregador_dataNascimento" ).toLocalDate() );
		return pregador;
		
	};
	
	@Override
	public List<Pregador> listarTodos() {
		return jdbc.query(
		"SELECT * FROM( "
		+"	SELECT * FROM pregador, tipo_pregador"
		+"	  WHERE pregador_tipo_pregador_id = tipo_pregador_id "
		+" ) a "
		+" left join arquivo b " 
		+"  on a.pregador_arquivo_id = b.arquivo_id", rowMapper );
	}

	@Override
	public Pregador buscarPorId(long id) {
		return jdbc.queryForObject(
		"SELECT * FROM( "
		+"	SELECT * FROM pregador, tipo_pregador "
		+"	  WHERE pregador_tipo_pregador_id = tipo_pregador_id "
		+ "     AND pregador_id = ? "
		+") a "
		+" left join arquivo b " 
		+"  on a.pregador_arquivo_id = b.arquivo_id", rowMapper, id );
	}

	@Override
	public Pregador inserirOuAtualizar(Pregador pregador) {
		
		long id         = pregador.getId();
		Arquivo imagem  = pregador.getImagem();
		Long arquivo_id = imagem == null ? null : imagem.getId();
		
		if( id == 0 ){
			long novoid = inserePregadorERetornaId(pregador);
			pregador.setId(novoid);
		}
		else{
			
			jdbc.update( "UPDATE pregador SET "
				+ "pregador_nome           = ?, "
				+ "pregador_dataNascimento = ?, "
				+ "pregador_email          = ?, "
				+ "pregador_telefone       = ?, "
				+ "pregador_endereco       = ?, "
				+ "pregador_arquivo_id     = ?  "
				+ "WHERE pregador_id = ?",
				pregador.getNome(),
				pregador.getDataNascimento(),
				pregador.getEmail(),
				//pregador.getTelefone(),
				//pregador.getEndereco(),
				arquivo_id,
				id
			);
		}
		return pregador;
	}

	@Override
	public boolean remover(long id) {
		return jdbc.update( "DELETE FROM pregador WHERE id = ?", id ) == 1;
	}
	
	private long inserePregadorERetornaId( Pregador pregador ){
		
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert( (JdbcTemplate)jdbc ).withTableName( "pregador" );
		jdbcInsert.setGeneratedKeyName( "id" );
		
		Arquivo arquivo = pregador.getImagem();
		Long arquivo_id = arquivo == null ? null : arquivo.getId();

		Map<String, Object> args = new HashMap<String, Object>();
		args.put( "pregador_nome" ,      pregador.getNome());
		args.put( "pregador_email",      pregador.getEmail());
		//args.put( "pregador_telefone",   pregador.getTelefone());
		//args.put( "pregador_endereco",   pregador.getEndereco());
		args.put( "pregador_status",     pregador.isStatus());
		args.put( "pregador_arquivo_id", arquivo_id );
		args.put( "pregador_dataNascimento" , java.sql.Date.valueOf( pregador.getDataNascimento()));
		args.put( "pregador_tipo_pregador_id", pregador.getTipoPregador().getId());		
				
		long id = jdbcInsert.executeAndReturnKey(args).longValue();
		return id;
	}


}
