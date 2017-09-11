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
import br.com.congregacao.model.Pais;
import br.com.congregacao.model.Pregador;
import br.com.congregacao.model.TipoPregador;

public class PregadorDAOImpl extends PregadorDAO{

	@Autowired
	private ArquivoDAO arquivoDAO;
	
	@Autowired
	private PaisDAO paisDAO;
	
	@Autowired
	private EstadoDAO estadoDAO;
	
	@Autowired
	private TipoPregadorDAO tipoPregadorDAO;
	
	
	private RowMapper<Pregador> rowMapper = ( rs, index ) ->{

		Pregador pregador = new Pregador();
				
		Callable<Pais> cpais       = ()->{ return paisDAO   .buscarPorId(rs.getLong("pregador_pais_id"));};
		Callable<Estado> cestado   = ()->{ return estadoDAO .buscarPorId(rs.getLong("pregador_estado_id"));};
		Callable<Arquivo> carquivo = ()->{ return arquivoDAO.buscarPorId(rs.getLong("pregador_arquivo_id"));};	
		Callable<TipoPregador> ctipoPregador = ()->{ return tipoPregadorDAO.buscarPorId(rs.getLong("pregador_tipo_pregador_id"));};
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		Future<Pais> fpais       = executorService.submit(cpais);
		Future<Estado> festado   = executorService.submit(cestado);
		Future<Arquivo> farquivo = executorService.submit(carquivo);	
		Future<TipoPregador> ftipoPregador = executorService.submit(ctipoPregador);
		
		executorService.shutdown();
		
		try {			
			pregador.setTipoPregador( ftipoPregador.get() );
			pregador.setPais  (fpais.get() );
			pregador.setEstado(festado.get());
			pregador.setImagem(farquivo.get());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	
				
		pregador.setId            ( rs.getLong   ( "pregador_id" ) );
		pregador.setNome          ( rs.getString ( "pregador_nome" ) );
		pregador.setSobrenome     ( rs.getString ( "pregador_sobrenome" ) );
		pregador.setDataNascimento( rs.getDate   ( "pregador_dataNascimento" ).toLocalDate() );
		pregador.setEmail         ( rs.getString ( "pregador_email" ));
		pregador.setStatus        ( rs.getBoolean( "pregador_status" ));
		pregador.setNumero        ( rs.getString ( "pregador_numero" ));
		pregador.setComplemento   ( rs.getString ( "pregador_complemento" ));
		pregador.setLogradouro    ( rs.getString ( "pregador_logradouro" ));
		pregador.setCep           ( rs.getString ( "pregador_cep" ));
		pregador.setBairro        ( rs.getString ( "pregador_bairro" ) );
		
		return pregador;
		
	};
	

	@Override
	public Map<String, Object> getArgs(Pregador pregador) {
		
		Map<String, Object> args = new HashMap<String, Object>();
		args.put( "pregador_nome", pregador.getNome());
		args.put( "pregador_sobrenome", pregador.getNome());
		args.put( "pregador_dataNascimento", java.sql.Date.valueOf( pregador.getDataNascimento()));
		args.put( "pregador_email", pregador.getEmail());
		args.put( "pregador_status", pregador.isStatus());
		args.put( "pregador_numero", pregador.getNumero());
		args.put( "pregador_complemento", pregador.getComplemento());
		args.put( "pregador_logradouro", pregador.getLogradouro());
		args.put( "pregador_cep", pregador.getCep());
		args.put( "pregador_bairro", pregador.getBairro());
		args.put( "pregador_arquivo_id", pregador.getIdDoArquivoOuRetorneNull());
		args.put( "pregador_tipo_pregador_id", pregador.getIdDoTipoDePregador());	
		args.put( "pregador_pais_id", pregador.getIdDoPais());
		args.put( "pregador_estado_id", pregador.getIdDoEstado());
			
		return args;
		
	}

	@Override
	public String getCampoId() {
		return "pregador_id";
	}

	@Override
	public String getTableName() {
		return "pregador";
	}

	@Override
	public String getCampos() {
		return 
		"pregador_id, "
	  + "pregador_nome, "
	  + "pregador_sobrenome, "
	  + "pregador_dataNascimento, "
	  + "pregador_email, "
	  + "pregador_status, "
	  + "pregador_numero, "
	  + "pregador_complemento, "
	  + "pregador_logradouro, "
	  + "pregador_cep, "
	  + "pregador_bairro, "
	  + "pregador_arquivo_id, "
	  + "pregador_tipo_pregador_id, "
	  + "pregador_pais_id, "
	  + "pregador_estado_id";
	}

	@Override
	public String getCamposUpdate() {
		return
	    "pregador_nome = ?, "
	  + "pregador_sobrenome = ?, "
	  + "pregador_dataNascimento = ?, "
	  + "pregador_email = ?, "
	  + "pregador_numero = ?, "
	  + "pregador_complemento = ?, "
	  + "pregador_logradouro = ?, "
	  + "pregador_cep = ?, "
	  + "pregador_bairro = ?, "
	  + "pregador_arquivo_id = ?, "
	  + "pregador_pais_id = ?, "
	  + "pregador_estado_id = ?";
		
	}

	@Override
	public Object[] getCamposValueUpdate(Pregador pregador) {
		
		Arquivo arquivo = pregador.getImagem();
		Long arquivo_id = arquivo == null ? null : arquivo.getId();
		
		return new Object[]{
			pregador.getNome(),
			pregador.getSobrenome(),
			java.sql.Date.valueOf(pregador.getDataNascimento()),
			pregador.getEmail(),
			pregador.getNumero(),
			pregador.getComplemento(),
			pregador.getLogradouro(),
			pregador.getCep(),
			pregador.getBairro(),
			arquivo_id,
			pregador.getPais().getId(),
			pregador.getEstado().getId(),
			pregador.getId()
		};
	}

	@Override
	public RowMapper<Pregador> getRowMapper() {
		return rowMapper;
	}


}
