package com.ufcg.si1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.SituacaoPrefeitura;
import com.ufcg.si1.repository.PrefeituraRepository;

/**
 * O "PrefeituraService" é responsável pela implementação das operações
 * específicas da classe "Prefeitura".
 * 
 * @author Lucas Christopher
 *
 */
@Service
public class PrefeituraService implements CrudService<Prefeitura, Integer> {

	private PrefeituraRepository prefeituraRepository;
	private Prefeitura prefeitura;

	@Autowired
	public PrefeituraService(PrefeituraService service, PrefeituraRepository repository) {
		this.prefeituraRepository = repository;
		this.prefeitura = new Prefeitura();
	}

	@Override
	public Prefeitura salvar(Prefeitura prefeitura) {
		return this.prefeituraRepository.save(prefeitura);
	}

	@Override
	public List<Prefeitura> listaTodos() {
		return this.prefeituraRepository.findAll();
	}

	@Override
	public Prefeitura atualizar(Prefeitura prefeitura) {
		return this.prefeituraRepository.save(prefeitura);
	}

	@Override
	public boolean removePorId(Integer id) {
		if (this.prefeituraRepository.exists(id)) {
			this.prefeituraRepository.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public Prefeitura getById(Integer id) {
		return this.prefeituraRepository.findOne(id);
	}

	public void modificaSituacao(SituacaoPrefeitura novaSituacao) {
		prefeitura.setSituacao(novaSituacao);
	}

}
