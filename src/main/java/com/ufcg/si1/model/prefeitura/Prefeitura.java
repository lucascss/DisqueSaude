package com.ufcg.si1.model.prefeitura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A "Prefeitura" é uma abstração que encapsula a sua situação e a sua
 * eficiência.
 * 
 * @author Anderson Vital
 *
 */
@Entity
public class Prefeitura {

	@Id
	@GeneratedValue
	private Integer id;

	private SituacaoPrefeitura situacaoPrefeitura;

	public Prefeitura() {
		this.situacaoPrefeitura = SituacaoPrefeitura.NORMAL;
	}

	public EficienciaPrefeitura getEficiencia(long proporcaoDeQueixasConcluidas) {
		return this.situacaoPrefeitura.getEficiencia(proporcaoDeQueixasConcluidas);
	}

	public void setSituacao(SituacaoPrefeitura situacao) {
		this.situacaoPrefeitura = situacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
