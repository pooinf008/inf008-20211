package contabil.model;

public interface ContabilLogicaIF {
	
	public void registarFatoContabil(String data,  
									 String descricao,
									 String debito,
									 String credito,
									 double valor) throws Exception;
	
	

}
