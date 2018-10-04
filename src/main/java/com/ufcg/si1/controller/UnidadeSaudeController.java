package com.ufcg.si1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.unidadedesaude.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

/**
 * É responsável por gerenciar a lógica de negócios da Unidade de Saúde e fazer
 * a interligação com o seu respectivo "Service".
 *
 * @author Anderson Vital
 * @author Lucas Christopher
 * @author Thalys Menezes
 */
@RestController
public class UnidadeSaudeController {

	UnidadeSaudeService unidadeSaudeService;

	@RequestMapping(value = "/especialidade/unidades", method = RequestMethod.GET)
	public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@RequestBody int codigoUnidadeSaude)
			throws ObjetoInexistenteException {

		Object us = null;
		us = unidadeSaudeService.getById(codigoUnidadeSaude);
		if (us instanceof UnidadeSaude) {
			UnidadeSaude us1 = (UnidadeSaude) us;
			return new ResponseEntity<>(us1.getEspecialidades(), HttpStatus.OK);
		}

		return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/unidade/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUnidades() {
		List<UnidadeSaude> unidades = unidadeSaudeService.listaTodos();
		if (unidades.isEmpty())
			return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
		else {
			List<UnidadeSaude> unidadeSaudes = new ArrayList<>();
			for (Object saude : unidades) {
				if (saude instanceof UnidadeSaude) {
					unidadeSaudes.add((UnidadeSaude) saude);
				}
			}
			return new ResponseEntity<>(unidadeSaudes, HttpStatus.OK);
		}
	}

	// how to save a subclass object?
	@RequestMapping(value = "/unidade/", method = RequestMethod.POST)
	public ResponseEntity<String> incluirUnidadeSaude(@RequestBody UnidadeSaude us, UriComponentsBuilder ucBuilder)
			throws ObjetoJaExistenteException {

		unidadeSaudeService.salvar(us);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/unidade/{id}").buildAndExpand(us.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/unidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) {

		Object us = unidadeSaudeService.getById((int) id);
		if (us == null) {
			return new ResponseEntity(new CustomErrorType("Unidade with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(us, HttpStatus.OK);
	}

	@RequestMapping(value = "/geral/medicos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {

		UnidadeSaude unidade = unidadeSaudeService.getById((int) id);

		if (unidade == null)
			return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);

		double media = unidade.calculaMediaMedicoPorPaciente();
		return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(new Double(media)), HttpStatus.OK);
	}

	@RequestMapping(value = "/unidade/busca", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaudePorBairro(
			@RequestParam(value = "bairro", required = true) String bairro) {

		List<UnidadeSaude> listaDaConsulta = this.unidadeSaudeService.getPorBairro(bairro);

		if (listaDaConsulta.isEmpty())
			return new ResponseEntity(new CustomErrorType("Unidade with bairro " + bairro + " not found"),
					HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(listaDaConsulta, HttpStatus.OK);

	}

}
