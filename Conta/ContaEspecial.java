public class ContaEspecial extends ContaCorrente{

    private double limite;
    
    public ContaEspecial(){
        this(0, 0);
    }    
    
    
    public ContaEspecial(double saldo, double limite){
        super(saldo);
    }    
    
    public ContaEspecial(double saldo){
        this(saldo, 0);
    }    
    
    
    public void sacar(double valor){
        if(valor <= this.getSaldo() + this.getLimite())
            this.saldo -= valor;
    }     
    
    public void setLimite(double limite){
        this.limite = limite;
    }    
    
    public double getLimite(){
        return this.limite; 
    } 
    
    public String toString(){
        return super.toString() + " - Limite R$" + this.getLimite();
    }    
    
    
}
