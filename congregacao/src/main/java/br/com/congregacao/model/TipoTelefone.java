package br.com.congregacao.model;

import br.com.congregacao.model.dao.ObjectDomain;

public class TipoTelefone implements ObjectDomain{

	private long id;
	private String nome;
	
	public TipoTelefone() {
		
	}
	
	public TipoTelefone(String nome) {
		this.nome = nome;
	}

	public TipoTelefone(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "TipoTelefone [id=" + id + ", nome=" + nome + "]";
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
