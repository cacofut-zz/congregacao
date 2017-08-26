package br.com.congregacao.model.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.congregacao.model.Midia;
import br.com.congregacao.model.Perfil;

public interface PerfilDAO extends DAO<Perfil>{
	
	public Perfil buscarPorDataEIdPregador( LocalDate data, long idPregador );
	
}
