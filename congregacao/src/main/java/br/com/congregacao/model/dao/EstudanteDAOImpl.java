package br.com.congregacao.model.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import br.com.congregacao.model.Arquivo;
import br.com.congregacao.model.Estado;
import br.com.congregacao.model.Estudante;
import br.com.congregacao.model.Pais;

public class EstudanteDAOImpl extends EstudanteDAO{
	
	@Autowired
	private ArquivoDAO arquivoDAO;
	@Autowired
	private EstadoDAO estadoDAO;
	@Autowired
	private PaisDAO paisDAO;
	
	private final static String CAMPO_ID   = "estudante_id";
	private final static String TABLE_NAME = "estudante";
	

	@Override
	public String getCampoId() {
		return CAMPO_ID;
	}

	@Override
	public String getTableName() {		
		return TABLE_NAME;
	}

	@Override
	public String getCampos() {
		return 
		"estudante_id, "
	  + "estudante_nome, "
	  + "estudante_sobrenome, "
	  + "estudante_arquivo_id, "
	  + "estudante_numero, "
	  + "estudante_complemento, "
	  + "estudante_logradouro, "
	  + "estudante_bairro, "
	  + "estudante_cep, "
	  + "estudante_pais_id, "
	  + "estudante_estado_id, "
	  + "estudante_pregador_id";
	}

	@Override
	public String getCamposUpdate() {		
		return 
		"estudante_nome = ?, "
	  + "estudante_sobrenome = ?, "
	  + "estudante_arquivo_id = ?, "
	  + "estudante_numero = ?, "
	  + "estudante_complemento = ?, "
	  + "estudante_logradouro = ?, "
	  + "estudante_bairro = ?, "
	  + "estudante_cep = ?, "
	  + "estudante_pais_id = ?, "
	  + "estudante_estado_id = ?";
	}

	@Override
	public Map<String, Object> getArgs(Estudante estudante) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("estudante_nome",        estudante.getNome());
		args.put("estudante_sobrenome",   estudante.getSobrenome());
		args.put("estudante_arquivo_id",  estudante.getImagemIdOrNull());
		args.put("estudante_numero",      estudante.getNumero());
		args.put("estudante_complemento", estudante.getComplemento());
		args.put("estudante_logradouro",  estudante.getLogradouro());
		args.put("estudante_bairro",      estudante.getBairro());
		args.put("estudante_cep", 		  estudante.getCep());
		args.put("estudante_pais_id",     estudante.getPaisId());
		args.put("estudante_estado_id",   estudante.getEstadoId());
		args.put("estudante_pregador_id", estudante.getPregadorId());
		return args;
	}

	@Override
	public Object[] getCamposValueUpdate(Estudante estudante) {
		return new Object[]{
			estudante.getNome(),
			estudante.getSobrenome(),
			estudante.getImagemIdOrNull(),
			estudante.getNumero(),
			estudante.getComplemento(),
			estudante.getLogradouro(),
			estudante.getBairro(),
			estudante.getCep(),
			estudante.getPaisId(),
			estudante.getEstadoId(),
			estudante.getId()
		};
	}

	@Override
	public RowMapper<Estudante> getRowMapper() {
		return (rs, index)->{
			
			Callable<Arquivo> carquivo = ()-> arquivoDAO.buscarPorId(rs.getLong("estudante_arquivo_id"));
			Callable<Estado> cestado   = ()-> estadoDAO.buscarPorId(rs.getLong("estudante_estado_id"));
			Callable<Pais> cpais	   = ()-> paisDAO.buscarPorId( rs.getLong("estudante_pais_id"));   
			
			ExecutorService executorService = Executors.newFixedThreadPool(3);
			
			Future<Arquivo> farquivo = executorService.submit(carquivo);
			Future<Estado>  festado  = executorService.submit(cestado);
			Future<Pais>    fpais    = executorService.submit(cpais);
			
			executorService.shutdown();

			Estudante estudante = new Estudante();
			estudante.setId         ( rs.getLong  ( "estudante_id" ));
			estudante.setNome       ( rs.getString( "estudante_nome" ));
			estudante.setSobrenome  ( rs.getString( "estudante_sobrenome" ));
			estudante.setNumero	    ( rs.getString( "estudante_numero" ));
			estudante.setComplemento( rs.getString( "estudante_complemento" ));
			estudante.setLogradouro ( rs.getString( "estudante_logradouro" ));
			estudante.setBairro     ( rs.getString( "estudante_bairro" ));
			estudante.setCep        ( rs.getString( "estudante_cep" ));
			estudante.setPregadorId ( rs.getLong( "estudante_pregador_id" ));	
			
			try {
				estudante.setImagem(farquivo.get());
				estudante.setEstado(festado.get());
				estudante.setPais(fpais.get());
			} catch (InterruptedException | ExecutionException e) {				
				e.printStackTrace();
			}
			
			return estudante;
		};
	}




}
