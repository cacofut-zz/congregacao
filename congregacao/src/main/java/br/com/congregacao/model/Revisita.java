package br.com.congregacao.model;

import java.time.LocalDate;

import br.com.congregacao.model.dao.ObjectDomain;

public class Revisita implements ObjectDomain{

	private long id;
	private String endereco;
	private String nome;
	private String observacoes;
	private LocalDate perfilData;
	private long perfilPregadorId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public LocalDate getPerfilData() {
		return perfilData;
	}
	public void setPerfilData(LocalDate perfilData) {
		this.perfilData = perfilData;
	}
	public long getPerfilPregadorId() {
		return perfilPregadorId;
	}
	public void setPerfilPregadorId(long perfilPregadorId) {
		this.perfilPregadorId = perfilPregadorId;
	}
	@Override
	public String toString() {
		return "Revisita [id=" + id + ", endereco=" + endereco + ", nome=" + nome + ", observacoes=" + observacoes
				+ ", perfilData=" + perfilData + ", perfilPregadorId=" + perfilPregadorId + "]";
	}
	
	
}
