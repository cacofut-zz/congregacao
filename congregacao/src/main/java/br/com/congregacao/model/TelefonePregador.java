package br.com.congregacao.model;

public class TelefonePregador {

	private long id;
	private String numero;
	private String pregadorNome;
	private String pregadorSobrenome;
	private TipoTelefone tipoTelefone;
	
	public TelefonePregador() {
	
	}
	
	public TelefonePregador(long id, String numero, String pregadorNome, String pregadorSobrenome,
			TipoTelefone tipoTelefone) {
		this.id = id;
		this.numero = numero;
		this.pregadorNome = pregadorNome;
		this.pregadorSobrenome = pregadorSobrenome;
		this.tipoTelefone = tipoTelefone;
	}

	public TelefonePregador(String numero, String pregadorNome, String pregadorSobrenome, TipoTelefone tipoTelefone) {
		this.numero = numero;
		this.pregadorNome = pregadorNome;
		this.pregadorSobrenome = pregadorSobrenome;
		this.tipoTelefone = tipoTelefone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPregadorNome() {
		return pregadorNome;
	}

	public void setPregadorNome(String pregadorNome) {
		this.pregadorNome = pregadorNome;
	}

	public String getPregadorSobrenome() {
		return pregadorSobrenome;
	}

	public void setPregadorSobrenome(String pregadorSobrenome) {
		this.pregadorSobrenome = pregadorSobrenome;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	@Override
	public String toString() {
		return "TelefonePregador [id=" + id + ", numero=" + numero + ", pregadorNome=" + pregadorNome
				+ ", pregadorSobrenome=" + pregadorSobrenome + ", tipoTelefone=" + tipoTelefone + "]";
	}
	
	
	
}
