public class LivroContabil{
    private Lancamento[] lancamentos;
    
    
    public LivroContabil(){
        this.lancamentos = new Lancamento[0];
     }    
    
    //TODO
    public void registarFatoContabil(String descricao,
                                     Conta contaCredito, 
                                     Conta contaDebito, 
                                     double valor){
        this.addLancamento(new Lancamento());                                         
        
    } 
    
    private void addLancamento(Lancamento lancamento){
        Lancamento[] novo = new Lancamento[this.lancamentos.length + 1];
        for(int i = 0; i < this.lancamentos.length; i++)
          novo[i] = this.lancamentos[i];
        novo[novo.length - 1] = lancamento;
        this.lancamentos = novo;
    }      
    
}
