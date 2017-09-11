package br.com.congregacao.model;

import br.com.congregacao.model.dao.ObjectDomain;

public class Estado implements ObjectDomain{

	private long id;
	private String nome;
	private String sigla;
	
	
	public Estado() {
		
	}
	
	public Estado(String nome, String sigla) {
		this.nome  = nome;
		this.sigla = sigla;
	}
	
	public Estado(long id) {
		this.id = id;
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	
	

}
