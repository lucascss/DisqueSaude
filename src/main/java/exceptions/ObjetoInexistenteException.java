package exceptions;

public class ObjetoInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObjetoInexistenteException(String erro) {
		super("ExcecaoDados: " + erro);
	}
}
