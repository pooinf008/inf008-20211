package contabil.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import contabil.model.entity.Conta;
import contabil.persistencia.ContaDAOFile;
import contabil.persistencia.ContaDAOIF;
import contabil.persistencia.ContaDAOSQL;

public class BalancoContabil{
	
	private ContaDAOIF contasDAO;
    
    public BalancoContabil() throws Exception{
    	this.contasDAO = new ContaDAOSQL();
    }    
    
    
    public void addConta(Conta conta) throws Exception{
    	this.contasDAO.salvar(conta);
    }    
    
    public Collection<Conta> findAll() throws Exception{
    	return this.contasDAO.findAll();
    }      
    
    public Conta findByNome(String nome) throws Exception{
    	return this.contasDAO.findByNome(nome);
    }    
    
    public void ajustar(String nomeCCredito, 
                        String nomeCDebito, 
                        double valor) throws Exception{
        Conta credito = this.findByNome(nomeCCredito);
        Conta debito =  this.findByNome(nomeCDebito);
        credito.creditar(valor);
        debito.debitar(valor);
        this.contasDAO.atualizar(credito);
        this.contasDAO.atualizar(debito);
    } 
    
    public String toString(){
    	Collection<Conta> contas;
		try {
			contas = this.contasDAO.findAll();
		} catch (Exception e) {
			contas = new ArrayList<Conta>();
		}
        String rep = "";
//        ArrayList<Conta> listaContas = new ArrayList<Conta>(contas);  
//        Collections.sort(listaContas);
        for(Conta conta : contas)
          rep = rep + conta + "\n";
        return rep;  
    }  
      
    
}
