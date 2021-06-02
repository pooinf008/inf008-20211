public class PatrLiquido extends Conta{
    
    public PatrLiquido(String codigo, String nome, double saldo){
        super(codigo, nome, saldo);
    }      
    
    public void debitar(double valor){
        saldo -= valor;
    }    
    
    public void creditar(double valor){
        saldo += valor;
    }     
    
    public String getCodTipo(){
        return "PL";
    }    
   
}
