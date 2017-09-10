package br.com.congregacao.model;

import br.com.congregacao.model.dao.ObjectDomain;

public class Pais implements ObjectDomain{

	private long id;
	private String nome;
	private String sigla;
	
	public Pais() {
	}
	
	public Pais(long id, String nome, String sigla) {
		this.id    = id;
		this.nome  = nome;
		this.sigla = sigla;
	}
	
	public Pais(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public Pais(long id) {
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
		return "Pais [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	
	
	
}
