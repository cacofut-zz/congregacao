package br.com.congregacao.model;

public class Endereco {

	private long id;
	private String rua;
	private String cep;
	private String numero;
	private long bairroId;

	public Endereco() {

	}

	public Endereco(long id) {
		this.id = id;
	}

	public Endereco(String rua, String cep, String numero, long bairroId) {

		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairroId = bairroId;
	}

	public Endereco(long id, String rua, String cep, String numero, long bairroId) {
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairroId = bairroId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public long getBairroId() {
		return bairroId;
	}

	public void setBairroId(long bairroId) {
		this.bairroId = bairroId;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", cep=" + cep + ", numero=" + numero + ", bairroId=" + bairroId
				+ "]";
	}
	
	

}
