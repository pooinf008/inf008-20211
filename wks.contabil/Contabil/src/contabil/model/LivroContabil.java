package contabil.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import contabil.model.entity.Conta;
import contabil.model.entity.Lancamento;
import contabil.model.order.ComparadorLancamentoPorDescricao;
import contabil.model.order.Ordenador;
import contabil.persistencia.ContaDAOIF;
import contabil.persistencia.LancamentoDAOIF;
import contabil.persistencia.LancamentoDAOSQL;

public class LivroContabil{
	
	private LancamentoDAOIF lancamentoDAO;
    
    public LivroContabil() throws SQLException{
		this.lancamentoDAO = new LancamentoDAOSQL();
    }    
    
    public void registarFatoContabil(java.util.Date data, String descricao,
                                     Conta contaCredito, 
                                     Conta contaDebito, 
                                     double valor) throws Exception{
        this.addLancamento(new Lancamento(data, descricao, contaCredito, contaDebito, valor));                                         
        
    } 
    
    private void addLancamento(Lancamento lancamento) throws Exception{
    	this.lancamentoDAO.salvar(lancamento);
    } 
    
    public String toString(){
    	
    	Collection<Lancamento> lancamentos;
		try {
			lancamentos = this.lancamentoDAO.findAll();
		} catch (Exception e) {
			lancamentos = new ArrayList<Lancamento>();
			e.printStackTrace();
		}
    	
        String rep = "";
        for(Lancamento lancamento : lancamentos)
          rep = rep + lancamento + "\n";
        return rep;  
    }
    
    
    public String relatorioPorValor(){
        String rep = "";
    	Collection<Lancamento> lancamentos;
		try {
			lancamentos = this.lancamentoDAO.findAll();
		} catch (Exception e) {
			lancamentos = new ArrayList<Lancamento>();
			e.printStackTrace();
		}
        for(Lancamento lancamento : lancamentos)
          rep = rep + lancamento + "\n";
        return rep;  
    }    
    
    
    
    
}
