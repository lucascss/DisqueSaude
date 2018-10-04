package com.ufcg.si1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.prefeitura.EficienciaPrefeitura;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.service.QueixaService;

/**
 * É responsável por gerenciar a lógica de negócios da Prefeitura e fazer a
 * interligação com o seu respectivo "Service".
 * 
 * @author Anderson Vital
 * @author Lucas Christopher
 * @author Thalys Menezes
 *
 */
@RestController
public class PrefeituraController {

	private QueixaService queixaService = new QueixaService(null);
	private Prefeitura prefeitura = new Prefeitura();

	public EficienciaPrefeitura getEficiencia() {
		return prefeitura.getEficiencia((long) queixaService.getProporcaoQueixasAbertasParaFechadas());
	}
}
