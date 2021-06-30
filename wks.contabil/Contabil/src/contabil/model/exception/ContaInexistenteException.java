package contabil.model.exception;

public class ContaInexistenteException extends Exception {
	
	private String nomeConta;

	public ContaInexistenteException(String nomeConta) {
		super();
		this.nomeConta = nomeConta;
	}
	

	public String getNomeConta() {
		return nomeConta;
	}
	
	

}
