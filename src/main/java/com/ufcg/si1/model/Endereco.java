package com.ufcg.si1.model;

import javax.persistence.Entity;

/**
 * A classe "Endereço" encapsula uma localização que contém uma rua, um bairro,
 * um estado e uma cidade.
 * 
 * @author Lucas Christopher
 *
 */
@Entity
public class Endereco {

	private String rua;

	private String bairro;

	private String estado;

	private String cidade;

	public Endereco() {}

	public Endereco(String rua, String bairro, String estado, String cidade) {
		this.rua = rua;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int primo = 31;
		int resultado = 1;

		resultado = primo * resultado + ((bairro == null) ? 0 : bairro.hashCode());
		resultado = primo * resultado + ((cidade == null) ? 0 : cidade.hashCode());
		resultado = primo * resultado + ((estado == null) ? 0 : estado.hashCode());
		resultado = primo * resultado + ((rua == null) ? 0 : rua.hashCode());

		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Endereco endereco = (Endereco) obj;

		return rua.equals(endereco.rua) && bairro.equals(endereco.bairro) && cidade.equals(endereco.cidade)
				&& estado.equals(endereco.estado);
	}

	@Override
	public String toString() {
		String resultado = "Endereco: {Rua: '" + this.rua + "', Bairro: '" + this.bairro + "', Cidade: '" + this.cidade
				+ "', Estado: '" + this.estado + "';}";

		return resultado;
	}

}
