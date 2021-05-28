public class RegistroContabil{
    private String nomeEmpresa;
    private String cnpjEmpresa;
    private BalancoContabil balanco;
    private LivroContabil livro;
    
    public RegistroContabil(String nomeEmpresa, String cnpjEmpresa){
        this.setNomeEmpresa(nomeEmpresa);
        this.setCnpjEmpresa(cnpjEmpresa);
        this.balanco = new BalancoContabil();
        this.livro = new LivroContabil();
    }  
    
    private void setNomeEmpresa(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;    
    }  
    
    private void setCnpjEmpresa(String cnpjEmpresa){
        this.cnpjEmpresa = cnpjEmpresa;    
    } 
    
    public void registarFatoContabil(String descricao, String nomeCDebito, 
                                     String nomeCCredito, double valor){
        Conta credito = this.balanco.findByNome(nomeCCredito);   
        Conta debito = this.balanco.findByNome(nomeCDebito);        
        this.livro.registarFatoContabil(descricao, credito, debito, valor);
        this.balanco.ajustar(nomeCCredito, nomeCDebito, valor);                                
    };
    
    public void addConta(String nome, int tipo){
        Conta conta = null;
        if(TipoConta.Ativo.value() == tipo)
            conta = new Ativo(nome, 0);
        else if(TipoConta.Passivo.value() == tipo)     
            conta = new Passivo(nome, 0);
        else if(TipoConta.PatrLiquido.value() == tipo)    
            conta = new PatrLiquido(nome, 0);
        this.balanco.addConta(conta);
    }  
    
    
    public String toString(){
        String rep = this.nomeEmpresa + "\t" + this.cnpjEmpresa + "\n";
        rep += "BALANCO\n";
        rep += this.balanco;
        rep += "LIVRO\n";
        rep += this.livro;
        return rep;
    }    
    
    
}
