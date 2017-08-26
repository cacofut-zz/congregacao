package br.com.congregacao.model.dao;

import java.util.List;

public interface DAO<T> {

	public List<T> listarTodos();
	public T buscarPorId( long id );
	public T inserirOuAtualizar( T objeto );
	public boolean remover( long id );
	
	
 }
