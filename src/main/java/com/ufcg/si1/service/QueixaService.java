package com.ufcg.si1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.repository.QueixaRepository;

/**
 * O "QueixaService" é responsável pela implementação das operações específicas
 * da classe "Queixa".
 * 
 * @author Lucas Christopher
 *
 */
@Service
public class QueixaService implements CrudService<Queixa, Integer> {

	private QueixaRepository queixaRepository;

	@Autowired
	public QueixaService(QueixaRepository queixaRepository) {
		this.queixaRepository = queixaRepository;
	}

	@Override
	public Queixa salvar(Queixa queixa) {
		return this.queixaRepository.save(queixa);
	}

	@Override
	public List<Queixa> listaTodos() {
		return this.queixaRepository.findAll();
	}

	@Override
	public Queixa atualizar(Queixa queixa) {
		return this.queixaRepository.save(queixa);
	}

	@Override
	public boolean removePorId(Integer id) {
		if (this.queixaRepository.exists(id)) {
			this.queixaRepository.delete(id);

			return true;
		}
		return false;
	}

	@Override
	public Queixa getById(Integer id) {
		return this.queixaRepository.findOne((int) id);
	}

	/**
	 * Calcula a proporção entre a quantidade de queixas abertas e a quantidade de
	 * queixas fechadas.
	 * 
	 * @return float representando a proporção
	 */
	public float getProporcaoQueixasAbertasParaFechadas() {
		int quantidadeQueixasAbertas = getQuantidadeQueixasPeloStatus("Aberta"),
				quantidadeQueixasFechadas = getQuantidadeQueixasPeloStatus("Fechada");

		float proporcao;

		if (quantidadeQueixasFechadas == 0)
			proporcao = quantidadeQueixasAbertas;
		else
			proporcao = ((float) quantidadeQueixasAbertas) / quantidadeQueixasFechadas;

		return proporcao;
	}

	/**
	 * Obtém a quantidade de queixas pelo status das mesmas.
	 * 
	 * @param statusQueixa
	 *            String que representa o status de consulta desejado
	 * @return o número de queixas no status passado como parametro
	 */
	private int getQuantidadeQueixasPeloStatus(String statusQueixa) {

		List<Queixa> todasAsQueixas = listaTodos();
		int quantidadeQueixasDoStatus = 0;

		for (Queixa queixa : todasAsQueixas) {
			if (queixa.getNomeSituacao().equals(statusQueixa))
				quantidadeQueixasDoStatus++;
		}
		return quantidadeQueixasDoStatus;
	}

}
