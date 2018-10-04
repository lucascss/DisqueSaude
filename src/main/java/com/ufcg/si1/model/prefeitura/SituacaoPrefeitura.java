package com.ufcg.si1.model.prefeitura;

/**
 * Este Enumeration é responsável por calcular a eficiência da Prefeitura e
 * definir os valores padrão para o limite das situações.
 * 
 * @author Anderson Vital
 *
 */
public enum SituacaoPrefeitura {

	NORMAL(0.97, 0.995), EXTRA(0.96, 0.99), CAOS(0.95, 0.98);

	double limiteRuim;
	double limiteRegular;

	private SituacaoPrefeitura(double limiteRuim, double limiteRegular) {
		this.limiteRuim = limiteRuim;
		this.limiteRegular = limiteRegular;
	}

	/**
	 * Método responsável por calcular a eficiência da "Prefeitura".
	 * 
	 * @param proporcaoDeQueixasConcluidas
	 *            Parâmetro recebido que serve de comparação para definir a
	 *            situação.
	 * @return Eficiência calculada.
	 */
	public EficienciaPrefeitura getEficiencia(long proporcaoDeQueixasConcluidas) {
		if (proporcaoDeQueixasConcluidas <= this.limiteRuim)
			return EficienciaPrefeitura.BAIXA;
		if (proporcaoDeQueixasConcluidas <= this.limiteRegular)
			return EficienciaPrefeitura.REGULAR;
		else
			return EficienciaPrefeitura.ALTA;
	}
}
