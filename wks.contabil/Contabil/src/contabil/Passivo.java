package contabil;
public class Passivo extends Conta{
    
    public Passivo(String codigo, String nome, double saldo){
        super(codigo, nome, saldo);
    }     
    
    
    public void debitar(double valor){
        saldo -= valor;
    }    
    
    public void creditar(double valor){
        saldo += valor;
    } 
    
    public String getCodTipo(){
        return "P";
    }    
    
    
}
