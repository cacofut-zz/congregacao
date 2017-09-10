package br.com.congregacao.model.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;


import br.com.congregacao.model.Perfil;
import br.com.congregacao.model.Estudante;
import br.com.congregacao.model.Revisita;

public class PerfilDAOImpl implements PerfilDAO{

	@Autowired
	private JdbcOperations jdbc;
	
	@Autowired
	private PregadorDAO pregadorDAO;
	

	@Autowired
	private RevisitaDAO revisitaDAO;
	
	private RowMapper<Perfil> rowMapper = ( rs, index ) ->{
		
		long pregadorId = rs.getLong( "perfil_pregador_id" );
		Perfil perfil   = new Perfil( rs.getLong( "perfil_id" ) );
		
		perfil.setData       ( rs.getDate  ( "perfil_data"  ).toLocalDate());
		perfil.setTempo		 ( rs.getTime  ( "perfil_tempo" ).toLocalTime());
		perfil.setObservacoes( rs.getString( "perfil_observacoes" ) );
		
		//Callable<Estudante>      c1 = ()->{ return pregadorDAO.buscarPorId(pregadorId);};
		Callable<List<Revisita>> c3 = ()->{	return revisitaDAO.buscarPorDataEIdPregador( perfil.getData(), pregadorId );};
		
		ExecutorService executorService       = Executors.newFixedThreadPool(3);
		//Future<Estudante> futurePregador       = executorService.submit( c1 );
		Future<List<Revisita>> futureRevisita = executorService.submit( c3 );
		executorService.shutdown();
		try {			
			//perfil.setPregador (futurePregador.get());
			perfil.setRevisitas(futureRevisita.get());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return perfil;
	};
	
	@Override
	public List<Perfil> listarTodos() {
		return jdbc.query(
		"SELECT perfil_id, perfil_data, perfil_pregador_id, perfil_tempo, perfil_observacoes "
		+ "FROM perfil ", rowMapper );
	}

	@Override
	public Perfil buscarPorId(long id) {
		return jdbc.queryForObject(
		"SELECT perfil_id, perfil_data, perfil_pregador_id, perfil_tempo, perfil_observacoes "
		+ "FROM perfil WHERE perfil_id = ?", rowMapper, id );
	}

	@Override
	public Perfil inserirOuAtualizar(Perfil objeto) {
		return null;
	}

	@Override
	public boolean remover(long id) {
		return false;
	}

	@Override
	public Perfil buscarPorDataEIdPregador(LocalDate data, long idPregador) {
		return jdbc.queryForObject(
			"SELECT perfil_id, perfil_data, perfil_pregador_id, perfil_tempo, perfil_observacoes "
			+ "FROM perfil "
			+ "WHERE perfil_data = ? "
			+ "  AND perfil_id   = ?", rowMapper, 
			new Object[]{ Date.valueOf( data ), 
			idPregador }
		);
	}

	
}
