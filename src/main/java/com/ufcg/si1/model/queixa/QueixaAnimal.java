package com.ufcg.si1.model.queixa;

import javax.persistence.Entity;

import com.ufcg.si1.model.Cidadao;
import com.ufcg.si1.model.Endereco;

/**
 * "QueixaAnimal" é uma subclasse de "Queixa" que adiciona um atributo
 * "tipoAnimal", especificando o tipo do animal que o solicitante refere-se.
 * 
 * @author Lucas Christopher
 *
 */
@Entity
public class QueixaAnimal extends Queixa {

	private String tipoAnimal;

	public QueixaAnimal() {}

	public QueixaAnimal(String comentario, String descricao, Endereco endereco, Cidadao solicitante,
			String tipoAnimal) {
		super(descricao, comentario, endereco, solicitante);
		this.tipoAnimal = tipoAnimal;
	}

	public String getTipoAnimal() {
		return this.tipoAnimal;
	}

	@Override
	public String toString() {
		String resultado = "Queixa de animal: {Tipo de animal: '" + this.tipoAnimal + "', Id: '" + this.id
				+ "', Comentario: '" + this.comentario + "', Descricao: '" + this.descricao + "', Endereco: '"
				+ this.endereco + "', Status: '" + this.situacao + "', Solicitante: '" + this.solicitante + "';}";

		return resultado;
	}

}
