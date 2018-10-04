package exceptions;

public class ObjetoJaExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObjetoJaExistenteException(String erro) {
		super("ExcecaoDados: " + erro);
	}
}
