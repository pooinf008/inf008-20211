public class BalancoContabil{
    public Conta[] contas;
    
    
    public BalancoContabil(){
        this.contas = new Conta[0];
    }    
    

    
    
    public void addConta(Conta conta){
        Conta[] novo = new Conta[this.contas.length + 1];
        for(int i = 0; i < this.contas.length; i++)
          novo[i] = this.contas[i];
        novo[novo.length - 1] = conta;
        this.contas = novo;
    }     
    
    
    public Conta findByNome(String nome){
        for(Conta conta : this.contas)
            if(conta.getNome().equals(nome))
              return conta;
        return null;      
    }    
    
    public void ajustar(String nomeCCredito, 
                        String nomeCDebito, 
                        double valor){
        this.findByNome(nomeCCredito).creditar(valor);
        this.findByNome(nomeCDebito).debitar(valor);
    } 
    
    public String toString(){
        String rep = "";
        new Ordenador().ordenar(this.contas);
        for(Conta conta : this.contas)
          rep = rep + conta + "\n";
        return rep;  
    }  
      
    
}
