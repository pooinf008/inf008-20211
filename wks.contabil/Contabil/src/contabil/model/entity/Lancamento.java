package contabil.model.entity;

import java.util.Date;

import contabil.model.order.Ordenavel;

public class Lancamento implements Ordenavel{
    private java.util.Date data;
    private String descricao;
    private double valor;
    private Conta credito;
    private Conta debito;
    
    public Lancamento(Date data, String descricao,
                      Conta contaCredito, 
                      Conta contaDebito, 
                      double valor){
        this.setData(data);
        this.setDescricao(descricao);
        this.setContaCredito(contaCredito);
        this.setContaDebito(contaDebito);
        this.setValor(valor);
    }
    
    private void setData(java.util.Date data){
        this.data = data;
    }    
    
    
    private void setDescricao(String descricao){
        this.descricao = descricao;
    }    
    
    private void setContaCredito(Conta contaCredito){
        this.credito = contaCredito;
    }    
    
    private void setContaDebito(Conta contaDebito){
        this.debito = contaDebito;
    }    
    
    private void setValor(double valor){
        this.valor = valor;
    }    
    
    public Date getData() {
    	return this.data;
    }
    
    
    public String getFmtData(){
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/YYYY");  
        return dateFormat.format(this.data);          
    }   
    
    public double getValor(){
        return this.valor;
    }    
    
    public String getDescricao(){
        return this.descricao;
    }      
    
    public String toString(){
        return this.getFmtData() +  "[" + this.descricao + "] D - " + this.debito.getNome() +
        " C - " + this.credito.getNome() + " R$ " + this.valor;
    }    
    
   
    public int compare(Ordenavel outro){
        if(!(outro instanceof Lancamento))        
            return 0;    
        Lancamento outroLancamento = (Lancamento) outro;
        if(this.data.before(outroLancamento.data))
            return - 1;
        else if (this.data.after(outroLancamento.data))   
            return + 1;
        return 0;
    }

	public Conta getContaCredito() {
		return this.credito;
	}         
    
	public Conta getContaDebito() {
		return this.debito;
	}         
    
    
                        
}
