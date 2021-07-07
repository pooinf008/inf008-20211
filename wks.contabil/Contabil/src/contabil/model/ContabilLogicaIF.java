package contabil.model;

import java.util.Collection;

public interface ContabilLogicaIF {
	public void registarFatoContabil(String data,  
									 String descricao,
									 String debito,
									 String credito,
									 double valor) throws Exception;
	
    public void addConta(String cod, String nome, int tipo) throws Exception;
    public Collection<String> getNomeContas() throws Exception;

}
