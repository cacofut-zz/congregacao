package br.com.congregacao.model;

import br.com.congregacao.model.dao.ObjectDomain;

public class TipoPregador implements ObjectDomain{

	private long id;
	private String nome;
	
	public TipoPregador() {
		
	}
	
	public TipoPregador(String nome) {
		this.nome = nome;
	}
	
	
	public TipoPregador(long id) {
		this.id = id;
	}

	public TipoPregador(long id, String nome) {
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
		return "TipoPregador [id=" + id + ", nome=" + nome + "]";
	}


	
	
	
	
	
}
