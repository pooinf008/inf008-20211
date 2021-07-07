package contabil.persistencia;

import java.util.Collection;

import contabil.model.entity.Lancamento;

public interface LancamentoDAOIF {
	public void salvar(Lancamento lancamento) throws Exception;
	public Collection<Lancamento> findAll() throws Exception;
}
