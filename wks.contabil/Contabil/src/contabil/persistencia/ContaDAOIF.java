package contabil.persistencia;

import java.util.Collection;

import contabil.model.entity.Conta;

public interface ContaDAOIF {

	public void salvar(Conta c) throws Exception;
	public void atualizar(Conta c) throws Exception;
	public Conta findByNome(String nome) throws Exception;
	public Collection<Conta> findAll() throws Exception;
	
}
