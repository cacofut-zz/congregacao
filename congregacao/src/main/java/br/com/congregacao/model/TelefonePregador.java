package br.com.congregacao.model;

import br.com.congregacao.model.dao.ObjectDomain;

public class TelefonePregador implements ObjectDomain{

	private long id;
	private String numero;
	private long pregadorId;
	private TipoTelefone tipoTelefone;
	
	public TelefonePregador() {
	
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public long getPregadorId() {
		return pregadorId;
	}

	public void setPregadorId(long pregadorId) {
		this.pregadorId = pregadorId;
	}

	@Override
	public String toString() {
		return "TelefonePregador [id=" + id + ", numero=" + numero + ", pregadorId=" + pregadorId + ", tipoTelefone="
				+ tipoTelefone + "]";
	}

	
	
	
}
