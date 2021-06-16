package contabil;
public abstract class Conta extends Object implements Ordenavel, java.io.Serializable{
    
    private String codigo;
    private String nome;
    protected double saldo;
    
    public Conta(String codigo, String nome, double saldo){
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setSaldo(saldo);
    }     
    
    public abstract void debitar(double valor);
    
    public abstract void creditar(double valor);

    private void setCodigo(String codigo){
        this.codigo = codigo;
    }    
    
    private void setNome(String nome){
        this.nome = nome;
    }    
    
    private void setSaldo(double saldo){
        this.saldo = saldo;
    }    
    
    
    public String getNome(){
        return this.nome;
    }  
    
    public String getCodigo(){
        return this.codigo;
    }  
    
    public String toString(){
        return "[" + this.getCodTipo() + "]" + this.getCodigo() + " - " + this.getNome() + "\t R$" + this.saldo;
    }  
    
    public abstract String getCodTipo();
    
    public int compare(Ordenavel outra){
        if(!(outra instanceof Conta))
            return 0;
        Conta outraConta = (Conta) outra;
        return this.codigo.compareToIgnoreCase(outraConta.codigo);
    }
    
    public boolean equals(Object object){
        if(!(object instanceof Conta))
            return false;
        Conta outraConta = (Conta) object;
        return this.codigo.equalsIgnoreCase(outraConta.codigo);
    }    
    
    
}
