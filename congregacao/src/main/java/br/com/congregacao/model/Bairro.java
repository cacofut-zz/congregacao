package br.com.congregacao.model;

public class Bairro {

	private long id;
	private String nome;
	private long cidadeId;

	public Bairro() {

	}

	public Bairro(long id) {
		this.id = id;
	}

	public Bairro(String nome, long cidadeId) {
		this.nome = nome;
		this.cidadeId = cidadeId;
	}

	public Bairro(long id, String nome, long cidadeId) {

		this.id = id;
		this.nome = nome;
		this.cidadeId = cidadeId;
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

	public long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(long cidadeId) {
		this.cidadeId = cidadeId;
	}

	@Override
	public String toString() {
		return "Bairro [id=" + id + ", nome=" + nome + ", cidadeId=" + cidadeId + "]";
	}
	
	

}
