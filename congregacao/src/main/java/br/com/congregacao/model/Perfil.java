package br.com.congregacao.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.congregacao.model.dao.ObjectDomain;

import static java.util.stream.Collectors.joining;
public class Perfil implements ObjectDomain{

	private long id;
	private Estudante pregador;
	private List<Publicacao> publicacoes;
	private List<Revisita> revisitas;
	private List<Estudo> estudos;
	private LocalDate data;
	private LocalTime tempo;
	private String observacoes;
	
	public Perfil() {
	
	}

	
	public Perfil(long id) {
		this.id = id;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estudante getPregador() {
		return pregador;
	}

	public void setPregador(Estudante pregador) {
		this.pregador = pregador;
	}

	public List<Revisita> getRevisitas() {
		return revisitas;
	}

	public void setRevisitas(List<Revisita> revisitas) {
		this.revisitas = revisitas;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getTempo() {
		return tempo;
	}

	public void setTempo(LocalTime tempo) {
		this.tempo = tempo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Estudo> getEstudos() {
		return estudos;
	}


	public void setEstudos(List<Estudo> estudos) {
		this.estudos = estudos;
	}


	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}


	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}


	@Override
	public String toString() {
		return "Perfil [id=" + id + ", pregador=" + pregador + ", publicacoes=" + publicacoes + ", revisitas="
				+ revisitas + ", estudos=" + estudos + ", data=" + data + ", tempo=" + tempo + ", observacoes="
				+ observacoes + "]";
	}

	
	
}
