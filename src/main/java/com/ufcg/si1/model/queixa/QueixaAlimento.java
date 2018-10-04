package com.ufcg.si1.model.queixa;

import javax.persistence.Entity;

import com.ufcg.si1.model.Cidadao;
import com.ufcg.si1.model.Endereco;

/**
 * "QueixaAlimento" é uma subclasse de "Queixa" que adiciona um atributo
 * "estabelecimento", ao qual a queixa se refere.
 * 
 * @author Lucas Christopher
 *
 */
@Entity
public class QueixaAlimento extends Queixa {

	private String estabelecimento;

	public QueixaAlimento() {}

	public QueixaAlimento(String comentario, String descricao, Endereco endereco, Cidadao socilitante,
			String estabelecimento) {
		super(descricao, comentario, endereco, socilitante);
		this.estabelecimento = estabelecimento;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	@Override
	public String toString() {
		String resultado = "Queixa de alimento: {Estabelecimento: '" + this.estabelecimento + "', Id: '" + this.id
				+ "', Comentario: '" + this.comentario + "', Descricao: '" + this.descricao + "', Endereco: '"
				+ this.endereco + "', Status: '" + this.situacao + "', Solicitante: '" + this.solicitante + "';}";

		return resultado;
	}

}
