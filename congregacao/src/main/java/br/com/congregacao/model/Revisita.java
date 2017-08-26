package br.com.congregacao.model;

import java.time.LocalDate;

public class Revisita {

	private long id;
	private String endereco;
	private String nome;
	private String observacoes;
	private LocalDate perfilData;
	private long perfilPregadorId;
	
	public Revisita() {
		
	}

	public Revisita(long id) {		
		this.id = id;
	}

	public Revisita(long id, String endereco, String nome, String observacoes, LocalDate perfilData,
			long perfilPregadorId) {	
		this.id = id;
		this.endereco = endereco;
		this.nome = nome;
		this.observacoes = observacoes;
		this.perfilData = perfilData;
		this.perfilPregadorId = perfilPregadorId;
	}

	public Revisita(String endereco, String nome, String observacoes, LocalDate perfilData, long perfilPregadorId) {
		this.endereco = endereco;
		this.nome = nome;
		this.observacoes = observacoes;
		this.perfilData = perfilData;
		this.perfilPregadorId = perfilPregadorId;
	}

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
		
		return String.format(
			"\n\t\t%-15s \n"
			+"\t\t\t%-15s = %s \n"
			+"\t\t\t%-15s = %s \n"
			+"\t\t\t%-15s = %s \n"
			+"\t\t\t%-15s = %s \n"
			+"\t\t%-15s \n",
			"Revisita[",
			"id", id, 
			"endereco", endereco, 
			"nome", nome, 
			"observacoes", observacoes,
			"]"
		);	
		
	}
	
	
}
