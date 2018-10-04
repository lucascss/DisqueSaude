package com.ufcg.si1.model.queixa;

/**
 * A "SituacaoDaQueixa" é um Enumeration que encapsula os diferentes estados de
 * andamento de uma queixa, imprimindo diferentes mensagens e utilizando o
 * padrão State.
 * 
 * @author Anderson Vital
 *
 */
public enum SituacaoDaQueixa {

	ABERTA("Aberta") {

		@Override
		public SituacaoDaQueixa abrir() {
			System.out.println("A queixa já está aberta.");
			return this;
		}

		@Override
		public SituacaoDaQueixa fechar() {
			System.out.println("A queixa foi fechada.");
			return SituacaoDaQueixa.FECHADA;
		}

	},

	EM_ANDAMENTO("Em andamento") {

		@Override
		public SituacaoDaQueixa abrir() {
			System.out.println("A queixa já está em andamento.");
			return this;
		}

		@Override
		public SituacaoDaQueixa fechar() {
			System.out.println("A queixa foi fechada.");
			return SituacaoDaQueixa.FECHADA;
		}
	},

	FECHADA("Fechada") {

		@Override
		public SituacaoDaQueixa abrir() {
			System.out.println("A queixa foi reaberta.");
			return SituacaoDaQueixa.ABERTA;
		}

		@Override
		public SituacaoDaQueixa fechar() {
			System.out.println("A queixa já está fechada.");
			return this;
		}

	};

	private String status;

	private SituacaoDaQueixa(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public abstract SituacaoDaQueixa abrir();

	public abstract SituacaoDaQueixa fechar();

}
