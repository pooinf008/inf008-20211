public class Lancamento{
    private String descricao;
    private double valor;
    private Conta credito;
    private Conta debito;
    
    public Lancamento(String descricao,
                      Conta contaCredito, 
                      Conta contaDebito, 
                      double valor){
        this.setDescricao(descricao);
        this.setContaCredito(contaCredito);
        this.setContaDebito(contaDebito);
        this.setValor(valor);
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
    
    public String toString(){
        return "[" + this.descricao + "] D - " + this.debito.getNome() +
        " C - " + this.credito.getNome() + " R$ " + this.valor;
    }    
        
    
    
    
                        
}
