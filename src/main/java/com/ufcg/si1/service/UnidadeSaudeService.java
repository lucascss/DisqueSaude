package com.ufcg.si1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.unidadedesaude.Especialidade;
import com.ufcg.si1.model.unidadedesaude.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

/**
 * O "UnidadeSaudeService" é responsável pela implementação das operações
 * específicas da classe "UnidadeSaude".
 * 
 * @author Lucas Christopher
 *
 */
@Service
public class UnidadeSaudeService implements CrudService<UnidadeSaude, Integer> {

	private UnidadeSaudeRepository unidadeSaudeRepository;

	@Autowired
	public UnidadeSaudeService(UnidadeSaudeRepository unidadeSaudeRepository) {
		this.unidadeSaudeRepository = unidadeSaudeRepository;
	}

	@Override
	public UnidadeSaude salvar(UnidadeSaude unidadeSaude) {
		return this.unidadeSaudeRepository.save(unidadeSaude);
	}

	@Override
	public List<UnidadeSaude> listaTodos() {
		return this.unidadeSaudeRepository.findAll();
	}

	@Override
	public UnidadeSaude atualizar(UnidadeSaude unidadeSaude) {
		return this.unidadeSaudeRepository.save(unidadeSaude);
	}

	@Override
	public boolean removePorId(Integer id) {
		if (this.unidadeSaudeRepository.exists(id)) {
			this.unidadeSaudeRepository.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public UnidadeSaude getById(Integer id) {
		return this.unidadeSaudeRepository.findOne(id);
	}

	public List<UnidadeSaude> getPorEspecialidade(Especialidade especialidade) {
		List<UnidadeSaude> todasAsUnidadesSaude = this.listaTodos(), unidadesSelecionadas = new ArrayList<>();

		for (UnidadeSaude unidadeSaude : todasAsUnidadesSaude) {
			if (unidadeSaude.contemEspecialidade(especialidade))
				unidadesSelecionadas.add(unidadeSaude);
		}

		return unidadesSelecionadas;
	}

	public List<UnidadeSaude> getPorBairro(String bairro) {
		List<UnidadeSaude> todasUnidadesSaude = this.listaTodos(), unidadesSelecionadas = new ArrayList<>();

		for (UnidadeSaude unidadeSaude : todasUnidadesSaude) {
			if (unidadeSaude.pertenceAoBairro(bairro))
				unidadesSelecionadas.add(unidadeSaude);
		}

		return unidadesSelecionadas;
	}

}
