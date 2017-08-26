package br.com.congregacao.model;

import java.time.LocalDate;

public class Pregador {

	private long  id;
	private String nome;
	private LocalDate dataNascimento;
	private String email;
	private String telefone;
	private boolean status;
	private TipoPregador tipoPregador;
	private Arquivo imagem;
	private Endereco endereco;
	
	public Pregador(){
		
	}

	public Pregador(long id) {	
		this.id = id;
	}

	public Pregador(long id, String nome, LocalDate dataNascimento, String email, String telefone, boolean status,
			TipoPregador tipoPregador, Arquivo imagem, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.status = status;
		this.tipoPregador = tipoPregador;
		this.imagem = imagem;
		this.endereco = endereco;
	}

	public Pregador(String nome, LocalDate dataNascimento, String email, String telefone, boolean status,
			TipoPregador tipoPregador, Arquivo imagem, Endereco endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.status = status;
		this.tipoPregador = tipoPregador;
		this.imagem = imagem;
		this.endereco = endereco;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public TipoPregador getTipoPregador() {
		return tipoPregador;
	}

	public void setTipoPregador(TipoPregador tipoPregador) {
		this.tipoPregador = tipoPregador;
	}

	public Arquivo getImagem() {
		return imagem;
	}

	public void setImagem(Arquivo imagem) {
		this.imagem = imagem;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pregador [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", email=" + email
				+ ", telefone=" + telefone + ", status=" + status + ", tipoPregador=" + tipoPregador + ", imagem="
				+ imagem + ", endereco=" + endereco + "]";
	}
	
	
	
}
