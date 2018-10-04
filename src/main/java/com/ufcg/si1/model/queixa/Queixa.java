package com.ufcg.si1.model.queixa;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ufcg.si1.model.Cidadao;
import com.ufcg.si1.model.Endereco;

/**
 * A "Queixa" encapsula uma reclamação, possuindo como estados: um id que a
 * identifica, uma descrição, um comentário, um solicitante e uma situação que
 * descreve o andamento da queixa.
 * 
 * @author Lucas Christopher
 * @author Thalys Menezes
 *
 */
@Entity
public abstract class Queixa {

	@Id
	@GeneratedValue
	protected Integer id;

	protected String descricao;

	protected String comentario;

	protected Cidadao solicitante;

	protected Endereco endereco;

	protected SituacaoDaQueixa situacao;

	public Queixa() {}

	public Queixa(String descricao, String comentario, Endereco endereco, Cidadao solicitante) {
		this.descricao = descricao;
		this.comentario = comentario;
		this.situacao = SituacaoDaQueixa.ABERTA;
		this.solicitante = solicitante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Cidadao getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Cidadao solicitante) {
		this.solicitante = solicitante;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public SituacaoDaQueixa getSituacao() {
		return situacao;
	}

	public String getNomeSituacao() {
		return situacao.getStatus();
	}

	public void setSituacao(SituacaoDaQueixa situacao) {
		this.situacao = situacao;
	}

	public void abrir() {
		this.situacao = this.situacao.abrir();
	}

	public void fechar() {
		this.situacao = this.situacao.fechar();
	}

	@Override
	public int hashCode() {
		final int primo = 31;
		int resultado = 1;
		resultado = primo * resultado + ((id == null) ? 0 : id.hashCode());
		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Queixa other = (Queixa) obj;

		return id.equals(other.id);
	}

	@Override
	public abstract String toString();

}
