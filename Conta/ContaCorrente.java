public class ContaCorrente extends Object{

    double saldo;
    
    public ContaCorrente(double saldo){
        this.saldo = saldo;
    }   
    
    public ContaCorrente(){
        this(0);
    }    
    
    
    public void depositar(double valor){
        this.saldo += valor; 
    } 
    
    public void sacar(double valor){
        if(valor <= this.getSaldo())
            this.saldo -= valor;
    }    
    
    public double getSaldo(){
        return this.saldo; 
    }
    
    public String toString(){
        return "Saldo R$" + this.getSaldo();
    }    
    
}
