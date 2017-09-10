package br.com.congregacao.model;

import java.time.LocalDate;

import br.com.congregacao.model.dao.ObjectDomain;

public class Estudo implements ObjectDomain{

	private long id;
	private LocalDate perfilData;
	private long perfilPregadorId;
	private long estudanteId;
	private String pregadorNome;
	private String pregadorSobrenome;
	
	public Estudo() {
	}

	public Estudo(LocalDate perfilData, long perfilPregadorId, long estudanteId, String pregadorNome,
			String pregadorSobrenome) {
		this.perfilData = perfilData;
		this.perfilPregadorId = perfilPregadorId;
		this.estudanteId = estudanteId;
		this.pregadorNome = pregadorNome;
		this.pregadorSobrenome = pregadorSobrenome;
	}

	public Estudo(long id, LocalDate perfilData, long perfilPregadorId, long estudanteId, String pregadorNome,
			String pregadorSobrenome) {
		this.id = id;
		this.perfilData = perfilData;
		this.perfilPregadorId = perfilPregadorId;
		this.estudanteId = estudanteId;
		this.pregadorNome = pregadorNome;
		this.pregadorSobrenome = pregadorSobrenome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getEstudanteId() {
		return estudanteId;
	}

	public void setEstudanteId(long estudanteId) {
		this.estudanteId = estudanteId;
	}

	public String getPregadorNome() {
		return pregadorNome;
	}

	public void setPregadorNome(String pregadorNome) {
		this.pregadorNome = pregadorNome;
	}

	public String getPregadorSobrenome() {
		return pregadorSobrenome;
	}

	public void setPregadorSobrenome(String pregadorSobrenome) {
		this.pregadorSobrenome = pregadorSobrenome;
	}

	@Override
	public String toString() {
		return "Estudo [id=" + id + ", perfilData=" + perfilData + ", perfilPregadorId=" + perfilPregadorId
				+ ", estudanteId=" + estudanteId + ", pregadorNome=" + pregadorNome + ", pregadorSobrenome="
				+ pregadorSobrenome + "]";
	}
	
	
	
}
