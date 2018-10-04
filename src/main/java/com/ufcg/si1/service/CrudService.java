package com.ufcg.si1.service;

import java.io.Serializable;
import java.util.List;

/**
 * O "CrudService" é uma interface que descreve as quatro operações básicas utilizadas em bases de dados relacionais (RDBMS),
 * no qual o seu nome faz referência a seu uso:
 * C - Create (criação ou adição);
 * R - Read (leitura ou busca);
 * U - Update (atualização);
 * D - Delete (remoção);
 * 
 * @author Lucas Christopher
 *
 * @param <T> Objeto genérico
 * @param <ID> Identificador único serializável.
 */
public interface CrudService<T, ID extends Serializable> {
	
	List<T> listaTodos();
	
	T salvar(T objeto);
	
	T getById(ID id);
	
	T atualizar(T objeto);
	
	boolean removePorId(ID id);

}
