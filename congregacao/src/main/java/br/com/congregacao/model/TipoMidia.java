package br.com.congregacao.model;

public class TipoMidia {

	private long id;
	private String nome;
	
	public TipoMidia() {
		
	}
	
	public TipoMidia(long id) {
		this.id = id;
	}


	public TipoMidia(String nome) {
		this.nome = nome;
	}

	public TipoMidia(long id, String nome) {	
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "TipoMidia [id=" + id + ", nome=" + nome + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
