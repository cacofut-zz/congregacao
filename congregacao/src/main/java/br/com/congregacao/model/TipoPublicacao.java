package br.com.congregacao.model;

import br.com.congregacao.model.dao.ObjectDomain;

public class TipoPublicacao implements ObjectDomain{

	private long id;
	private String nome;
	
	public TipoPublicacao() {
	
	}
	
	public TipoPublicacao(String nome) {
	
		this.nome = nome;
	}
	
	public TipoPublicacao(long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	@Override
	public String toString() {
		return "TipoPublicacao [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
