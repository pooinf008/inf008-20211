public class LivroContabil{
    private Lancamento[] lancamentos;
    
    
    public LivroContabil(){
        this.lancamentos = new Lancamento[0];
     }    
    
    public void registarFatoContabil(java.util.Date data, String descricao,
                                     Conta contaCredito, 
                                     Conta contaDebito, 
                                     double valor){
        this.addLancamento(new Lancamento(data, descricao, contaCredito, contaDebito, valor));                                         
        
    } 
    
    private void addLancamento(Lancamento lancamento){
        Lancamento[] novo = new Lancamento[this.lancamentos.length + 1];
        for(int i = 0; i < this.lancamentos.length; i++)
          novo[i] = this.lancamentos[i];
        novo[novo.length - 1] = lancamento;
        this.lancamentos = novo;
    } 
    
    public String toString(){
        String rep = "";
        new Ordenador().ordenar(this.lancamentos);
        for(Lancamento lancamento : this.lancamentos)
          rep = rep + lancamento + "\n";
        return rep;  
    }
    
    
    public String relatorioPorValor(){
        String rep = "";
        new Ordenador().ordenar(this.lancamentos, new ComparadorLancamentoPorDescricao());
        for(Lancamento lancamento : this.lancamentos)
          rep = rep + lancamento + "\n";
        return rep;  
    }    
    
    
    
    
}
