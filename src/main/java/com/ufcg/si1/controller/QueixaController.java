package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;

/**
 * É responsável por gerenciar a lógica de negócios da Queixa e fazer a
 * interligação com o seu respectivo "Service".
 * 
 * @author Anderson Vital
 * @author Lucas Christopher
 * @author Thalys Menezes
 *
 */
@RestController
public class QueixaController {

	private QueixaService queixaService;

	@Autowired
	public QueixaController(QueixaService queixaService) {
		this.queixaService = queixaService;
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Queixa> insereQueixa(@RequestBody Queixa queixa) {
		return new ResponseEntity<Queixa>(this.queixaService.salvar(queixa), HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Queixa> atualizaQueixa(@PathVariable("id") Integer id) {
		Queixa queixa = this.queixaService.getById(id);

		if (queixa == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		this.queixaService.atualizar(queixa);
		return new ResponseEntity<Queixa>(queixa, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/", method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> listAllUsers() {
		List<Queixa> queixas = this.queixaService.listaTodos();
		if (queixas.isEmpty())
			return new ResponseEntity<List<Queixa>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.GET)
	public ResponseEntity<Queixa> consultarQueixa(@PathVariable("id") Integer id) {
		Queixa queixa = this.queixaService.getById(id);

		if (queixa == null)
			return new ResponseEntity<Queixa>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Queixa>(queixa, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> apagaQueixa(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(this.queixaService.removePorId(id), HttpStatus.OK);
	}

}
