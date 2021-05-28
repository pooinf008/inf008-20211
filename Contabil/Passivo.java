public class Passivo extends Conta{
    
    public Passivo(String nome, double saldo){
        super(nome, saldo);
    }     
    
    
    public void debitar(double valor){
        saldo -= valor;
    }    
    
    public void creditar(double valor){
        saldo += valor;
    }    
    
}
