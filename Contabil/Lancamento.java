public class Lancamento implements Ordenavel{
    private java.util.Date data;
    private String descricao;
    private double valor;
    private Conta credito;
    private Conta debito;
    
    public Lancamento(java.util.Date data, String descricao,
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
    
    
    public String getFmtData(){
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");  
        return dateFormat.format(this.data);          
    }        
    
    public String toString(){
        return this.getFmtData() +  "[" + this.descricao + "] D - " + this.debito.getNome() +
        " C - " + this.credito.getNome() + " R$ " + this.valor;
    }    
    
   
    public int compare(Ordenavel outro){
        Lancamento outroLancamento = (Lancamento) outro;
        if(this.data.before(outroLancamento.data))
            return - 1;
        else if (this.data.after(outroLancamento.data))   
            return + 1;
        return 0;
    }         
    
    
    
                        
}
