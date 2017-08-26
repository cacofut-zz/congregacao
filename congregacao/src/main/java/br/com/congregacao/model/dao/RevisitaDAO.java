package br.com.congregacao.model.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.congregacao.model.Midia;
import br.com.congregacao.model.Revisita;

public interface RevisitaDAO extends DAO<Revisita>{

	public List<Revisita> buscarPorDataEIdPregador( LocalDate data, long idPregador );
}
