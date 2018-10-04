package com.ufcg.si1.model.unidadedesaude;

import java.util.Set;

import javax.persistence.Entity;

import com.ufcg.si1.model.Endereco;

/**
 * "PostoSaude" extende de uma Unidade de Saúde, sobrescrevendo o cálculo da
 * taxa de pacientes por dia com base em sua taxa diária de atendimentos.
 * 
 * @author Lucas Christopher
 *
 */
@Entity
public class PostoSaude extends UnidadeSaude {

	private float taxaDiariaAtendimentos;

	public PostoSaude(String descricao, Endereco endereco, Set<Especialidade> especialidades, int quantidadeMedicos,
			int taxaDiariaAtendimentos) {
		super(descricao, endereco, especialidades, quantidadeMedicos);
		this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
	}

	public PostoSaude() {
		super();
	}

	@Override
	public float getTaxaPacientesPorDia() {
		return this.taxaDiariaAtendimentos;
	}

	@Override
	public String toString() {
		String resultado = "Posto de Saude: { Taxa de pacientes por dia : '" + this.taxaDiariaAtendimentos + "', Id: '"
				+ this.id + "', Descricao: '" + this.descricao + "', Endereco: '" + this.endereco
				+ "', Especialidades: '" + this.especialidades + "', Quantidade de Medicos: '" + this.quantidadeMedicos
				+ "';}";

		return resultado;
	}
}
