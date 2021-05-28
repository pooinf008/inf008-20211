public class App{
    
    private static final int  ATIVO = 1;
    private static final int  PASSIVO = 2;
    private static final int  PATR_LIQUIDO = 3;
    
    private RegistroContabil registro;
        
    
    public App(){
        this.registro = new RegistroContabil("ACME", "0000000000000");
    }    
    
    public void run(){
        this.registro.addConta("IMOVEIS", App.ATIVO);
        this.registro.addConta("CAIXA", App.ATIVO);
        this.registro.addConta("CAPITAL", App.PATR_LIQUIDO);
        this.registro.addConta("EMPRESTIMO", App.PASSIVO);
        
        this.registro.registarFatoContabil("Integralizacao",
                                           "CAIXA", "CAPITAL", 5000);
        this.registro.registarFatoContabil("Compra da Sede",
                                           "IMOVEIS", "CAIXA", 2000);
        this.registro.registarFatoContabil("Compra da Sede",
                                           "CAIXA", "EMPRESTIMO", 3000);
                                           
        System.out.println(this.registro);                                           
    }   
    
    public static void main(String[] args){
        (new App()).run();
    }    
    
}
