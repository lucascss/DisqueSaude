package com.ufcg.si1.model.unidadedesaude;

import javax.persistence.Entity;

/**
 * A "Especialidade" refere-se a uma especialidade de uma Unidade de Saúde.
 * 
 * @author Lucas Christopher
 *
 */
@Entity
public class Especialidade {

	private String nomeEspecialidade;

	public Especialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public Especialidade() {}

	public String getDescricao() {
		return this.nomeEspecialidade;
	}

	public void setDescricao(String descricao) {
		this.nomeEspecialidade = descricao;
	}

	@Override
	public int hashCode() {
		final int primo = 31;
		int resultado = 1;
		resultado = primo * resultado + ((nomeEspecialidade == null) ? 0 : nomeEspecialidade.hashCode());
		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Especialidade other = (Especialidade) obj;

		return nomeEspecialidade.equals(other.nomeEspecialidade);
	}

	@Override
	public String toString() {
		return "Especialidade: {Nome: '" + this.nomeEspecialidade + "'}";
	}

}
