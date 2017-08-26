package br.com.congregacao.model;

import static java.util.stream.Collectors.joining;

import java.time.LocalDate;

public class Midia {

	private long id;
	private TipoMidia tipoMidia;
	private String titulo;
	private int quantidade;
	private Arquivo imagem;	
	private LocalDate perfilData;
	private long pregadorId;
	
	public Midia() {
		
	}
	
	public Midia(long id) {
		this.id = id;
	}

	public Midia(TipoMidia tipoMidia, String titulo, int quantidade, Arquivo imagem, LocalDate perfilData,
			long pregadorId) {
		this.tipoMidia = tipoMidia;
		this.titulo = titulo;
		this.quantidade = quantidade;
		this.imagem = imagem;
		this.perfilData = perfilData;
		this.pregadorId = pregadorId;
	}



	public Midia(long id, TipoMidia tipoMidia, String titulo, int quantidade, Arquivo imagem, LocalDate perfilData,
			long pregadorId) {	
		this.id = id;
		this.tipoMidia = tipoMidia;
		this.titulo = titulo;
		this.quantidade = quantidade;
		this.imagem = imagem;
		this.perfilData = perfilData;
		this.pregadorId = pregadorId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoMidia getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoMidia tipoMidia) {
		this.tipoMidia = tipoMidia;
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

	public Arquivo getImagem() {
		return imagem;
	}

	public void setImagem(Arquivo imagem) {
		this.imagem = imagem;
	}

	public LocalDate getPerfilData() {
		return perfilData;
	}

	public void setPerfilData(LocalDate perfilData) {
		this.perfilData = perfilData;
	}

	public long getPregadorId() {
		return pregadorId;
	}

	public void setPregadorId(long pregadorId) {
		this.pregadorId = pregadorId;
	}
	
	@Override
	public String toString() {	
		
		return String.format(
			"\n\t\t%-15s \n"
			+"\t\t\t%-15s = %s  \n"
			+"\t\t\t%-15s = %s  \n"
			+"\t\t\t%-15s = %s  \n"
			+"\t\t\t%-15s = %s  \n"
			+"\t\t\t%-15s = %s  \n"
			+"\t\t%-15s \n",
			"Midia[",
			"id", id, 
			"tipoMidia", tipoMidia, 
			"titulo", titulo, 
			"quantidade", quantidade,
			"imagem", imagem,
			"]"
		);	
		
	}
	
	
	
	
	
}
