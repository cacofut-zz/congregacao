package br.com.congregacao.model.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.congregacao.model.Midia;

public interface MidiaDAO extends DAO<Midia>{

	public List<Midia> buscarPorDataEIdPregador( LocalDate data, long idPregador );  
}
