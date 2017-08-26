package br.com.congregacao.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.joining;
public class Perfil {

	private long id;
	private Pregador pregador;
	private List<Midia> midias;
	private List<Revisita> revisitas;
	private LocalDate data;
	private LocalTime tempo;
	private String observacoes;
	
	public Perfil() {
	
	}

	
	public Perfil(long id) {
		this.id = id;
	}


	public Perfil(long id, Pregador pregador, List<Midia> midias, List<Revisita> revisitas, LocalDate data,
			LocalTime tempo, String observacoes) {
	
		this.id = id;
		this.pregador = pregador;
		this.midias = midias;
		this.revisitas = revisitas;
		this.data = data;
		this.tempo = tempo;
		this.observacoes = observacoes;
	}

	public Perfil(Pregador pregador, List<Midia> midias, List<Revisita> revisitas, LocalDate data, LocalTime tempo,
			String observacoes) {	
		this.pregador = pregador;
		this.midias = midias;
		this.revisitas = revisitas;
		this.data = data;
		this.tempo = tempo;
		this.observacoes = observacoes;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pregador getPregador() {
		return pregador;
	}

	public void setPregador(Pregador pregador) {
		this.pregador = pregador;
	}

	public List<Midia> getMidias() {
		return midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
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

	@Override
	public String toString() {	
		
		final String midiasJoined = midias.stream()
				.map(item ->  item + "" )
	            .collect(joining("\t],[", "[", "\t]"));
		
		final String revisitasJoined = revisitas.stream()
				.map(item ->  item + "" )
	            .collect(joining("\t],[", "[", "\t]"));
	        
		return String.format(
			"Perfil[\n"
			+ "\t%-11s = %s \n"
			+ "\t%-11s = %s \n"
			+ "\t%-11s = %s \n"
			+ "\t%-11s = %s \n"
			+ "\t%-11s = %s \n"
			+ "\t%-11s = %s \n"
			+ "\t%-11s = %s \n",
			"id", id, 
			"pregador", pregador, 
			"midias", midiasJoined, 
			"revisitas", revisitasJoined,
			"data", data,
			"tempo", tempo,
			"observacoes", observacoes
		);	
	}

	
	
	
}
