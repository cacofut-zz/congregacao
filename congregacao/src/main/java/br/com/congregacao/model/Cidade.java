package br.com.congregacao.model;

public class Cidade {

	private long id;
	private String nome;
	private long estadoId;
	
	public Cidade() {
		
	}
	
	public Cidade(long id) {
		this.id = id;
	}

	public Cidade(long id, String nome, long estadoId) {
		this.id = id;
		this.nome = nome;
		this.estadoId = estadoId;
	}

	public Cidade(String nome, long estadoId) {
		this.nome = nome;
		this.estadoId = estadoId;
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

	public long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(long estadoId) {
		this.estadoId = estadoId;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", estadoId=" + estadoId + "]";
	}
	
	
	
	
}
