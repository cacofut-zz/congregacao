package br.com.congregacao.model;

import java.time.LocalDate;

public class Video {

	private long id;
	private String titulo;
	private int quantidade;
	private LocalDate perfilData;
	private long perfilPregadorId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
		return "Video [id=" + id + ", titulo=" + titulo + ", quantidade=" + quantidade + ", perfilData=" + perfilData
				+ ", perfilPregadorId=" + perfilPregadorId + "]";
	}
	
	
}
