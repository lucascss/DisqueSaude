package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A classe "Cidadão" é a abstração para pessoa no projeto. Um Cidadão possui um
 * nome, um email e um endereço, tal como um "id" que o identifica em todo o
 * sistema.
 * 
 * @author Lucas Christopher
 *
 */

@Entity
public class Cidadao {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	private String email;

	private Endereco endereco;

	public Cidadao() {}

	public Cidadao(String nome, String email, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int primo = 31;
		int resultado = 1;

		resultado = primo * resultado + ((email == null) ? 0 : email.hashCode());
		resultado = primo * resultado + ((endereco == null) ? 0 : endereco.hashCode());
		resultado = primo * resultado + ((id == null) ? 0 : id.hashCode());
		resultado = primo * resultado + ((nome == null) ? 0 : nome.hashCode());

		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Cidadao pessoa = (Cidadao) obj;

		return id.equals(pessoa.id);
	}

	@Override
	public String toString() {
		String resultado = "Cidadao: {Id: '" + this.id + "', Nome: '" + this.nome + "', Email: '" + this.email
				+ "', Endereco: '" + this.endereco + "';}";

		return resultado;
	}

}
