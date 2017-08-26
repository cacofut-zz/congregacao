package br.com.congregacao.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.congregacao.model.Perfil;
import br.com.congregacao.model.dao.PerfilDAO;

@Service
public class PerfilService {

	@Autowired
	private PerfilDAO perfilDAO;
	
	public Perfil buscarPorDataEIdPregador(LocalDate data, long idPregador){
		return perfilDAO.buscarPorDataEIdPregador(data, idPregador);
	}
}
