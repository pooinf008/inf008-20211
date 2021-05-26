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
    
    public void registarFatoContabil(String descricao, String nomeCCredito, 
                                     String nomeCDebito, double valor){
        Conta credito = this.balanco.findByNome(nomeCCredito);   
        Conta debito = this.balanco.findByNome(nomeCDebito);        
        this.livro.registarFatoContabil(descricao, credito, debito, valor);
        this.balanco.ajustar(nomeCCredito, nomeCDebito, valor);                                
    }; 
    
    
}
