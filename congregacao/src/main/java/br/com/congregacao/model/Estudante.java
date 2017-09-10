package br.com.congregacao.model;

import java.util.List;

import br.com.congregacao.model.dao.ObjectDomain;

public class Estudante implements ObjectDomain{

	private long  id;
	private String nome;
	private String sobrenome;
	private Arquivo imagem;
	private String numero;
	private String complemento;
	private String logradouro;
	private String bairro;
	private int cep;
	private Pais pais;
	private Estado estado;
	private String pregadorNome;
	private String pregadorSobrenome;
	private List<TelefonePregador> telefones;
	
	

	public Estudante() {
	
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Arquivo getImagem() {
		return imagem;
	}

	public void setImagem(Arquivo imagem) {
		this.imagem = imagem;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<TelefonePregador> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefonePregador> telefones) {
		this.telefones = telefones;
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
		return "Estudante [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", imagem=" + imagem
				+ ", numero=" + numero + ", complemento=" + complemento + ", logradouro=" + logradouro + ", bairro="
				+ bairro + ", cep=" + cep + ", pais=" + pais + ", estado=" + estado + ", pregadorNome=" + pregadorNome
				+ ", pregadorSobrenome=" + pregadorSobrenome + ", telefones=" + telefones + "]";
	}

	
	
}
