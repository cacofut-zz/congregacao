package br.com.congregacao.model;

public class Estado {

	private long id;
	private String nome;
	private String sigla;
	private long paisId;
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public long getPaisId() {
		return paisId;
	}
	public void setPaisId(long paisId) {
		this.paisId = paisId;
	}
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", paisId=" + paisId + "]";
	}

	

}
