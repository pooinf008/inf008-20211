public abstract class Conta{
    
    private String nome;
    protected double saldo;
    
    public Conta(String nome, double saldo){
        this.setNome(nome);
        this.setSaldo(saldo);
    }     
    
    public abstract void debitar(double valor);
    
    public abstract void creditar(double valor);
    
    private void setNome(String nome){
        this.nome = nome;
    }    
    
    private void setSaldo(double saldo){
        this.saldo = saldo;
    }    
    
    
    public String getNome(){
        return this.nome;
    }  
    
    public String toString(){
        return this.getNome() + "\t R$" + this.saldo;
    }    
    
    
}
