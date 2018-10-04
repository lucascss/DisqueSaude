package com.ufcg.si1.model.unidadedesaude;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ufcg.si1.model.Endereco;

/**
 * A classe abstrata "UnidadeSaude" abstrai uma Unidade de Saúde que encapsula
 * uma especialidade, um endereço e uma determinada quantidade de médicos.
 * 
 * @author Lucas Christopher
 *
 */
@Entity
public abstract class UnidadeSaude {

	@Id
	@GeneratedValue
	protected int id;

	protected String descricao;

	protected Endereco endereco;

	protected Set<Especialidade> especialidades;

	protected int quantidadeMedicos;

	public UnidadeSaude() {}

	public UnidadeSaude(String descricao, Endereco endereco, Set<Especialidade> especialidades, int quantidadeMedicos) {
		this.descricao = descricao;
		this.endereco = endereco;
		this.especialidades = especialidades;
		this.quantidadeMedicos = quantidadeMedicos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public int getQuantidadeMedicos() {
		return quantidadeMedicos;
	}

	public void setQuantidadeMedicos(int quantidadeMedicos) {
		this.quantidadeMedicos = quantidadeMedicos;
	}

	public void adicionarEspecialidade(Especialidade especialidades) {
		this.especialidades.add(especialidades);
	}

	public boolean contemEspecialidade(Especialidade especialidade) {
		return this.especialidades.contains(especialidade);
	}

	public boolean pertenceAoBairro(String bairro) {
		return this.endereco.getBairro().equals(bairro);
	}

	public float calculaMediaMedicoPorPaciente() {
		if (getTaxaPacientesPorDia() == 0)
			// FIXME: Adicionar exception personalizada (ValorInvalidoException)
			throw new RuntimeException("Taxa de pacientes por dia não pode ser zero.");

		return this.quantidadeMedicos / getTaxaPacientesPorDia();
	}

	public abstract float getTaxaPacientesPorDia();

	@Override
	public abstract String toString();
}
