public class PatrLiquido extends Conta{
    public void debitar(double valor){
        saldo -= valor;
    }    
    
    public void creditar(double valor){
        saldo += valor;
    }    
}
