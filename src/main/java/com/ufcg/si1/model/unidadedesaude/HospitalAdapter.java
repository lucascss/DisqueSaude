package com.ufcg.si1.model.unidadedesaude;

import java.util.Set;

import javax.persistence.Entity;

import com.ufcg.si1.model.Endereco;

import br.edu.ufcg.Hospital;

/**
 * A classe "HospitalAdapter" faz a ligação entre o arquivo ".jar" e o código de
 * sistema, fazendo uso do padrão de projeto "Adapter".
 * 
 * @author Lucas Christopher
 *
 */

@Entity
public class HospitalAdapter extends UnidadeSaude {

	private Hospital hospital;

	private int numeroPacientesDia;

	public HospitalAdapter() {
		super();
	}

	public HospitalAdapter(String descricao, Endereco endereco, Set<Especialidade> especialidades,
			int quantidadeMedicos, int numeroPacientesDia) {
		super(descricao, endereco, especialidades, quantidadeMedicos);

		this.numeroPacientesDia = numeroPacientesDia;
		this.hospital = new Hospital(descricao, quantidadeMedicos, numeroPacientesDia);
	}

	public Hospital getHospital() {
		return hospital;
	}

	@Override
	public float getTaxaPacientesPorDia() {
		return this.numeroPacientesDia;
	}

	@Override
	public String toString() {
		String resultado = "Hospital: { Taxa de pacientes por dia : '" + this.numeroPacientesDia + "', Id: '" + this.id
				+ "', Descricao: '" + this.descricao + "', Endereco: '" + this.endereco + "', Especialidades: '"
				+ this.especialidades + "', Quantidade de Medicos: '" + this.quantidadeMedicos + "';}";

		return resultado;
	}

}
