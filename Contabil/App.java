public class App{
    
    private static final int  ATIVO = 1;
    private static final int  PASSIVO = 2;
    private static final int  PATR_LIQUIDO = 3;
    
    private RegistroContabil registro;
        
    
    public App(){
        this.registro = new RegistroContabil("ACME", "0000000000000");
    }    
    
    public void run() throws java.text.ParseException{
        this.registro.addConta("1.3", "IMOVEIS", App.ATIVO);
        this.registro.addConta("1.1","CAIXA", App.ATIVO);
        this.registro.addConta("3.1", "CAPITAL", App.PATR_LIQUIDO);
        this.registro.addConta("2.1", "EMPRESTIMO", App.PASSIVO);
        
        this.registro.registarFatoContabil("01/02/2021",  "Compra da Sede",
                                           "IMOVEIS", "CAIXA", 2000);
        this.registro.registarFatoContabil("01/01/2021", "Integralizacao",
                                           "CAIXA", "CAPITAL", 5000);
        this.registro.registarFatoContabil("01/03/2021", "Tomada de Emprestimo Bco XXX",
                                           "CAIXA", "EMPRESTIMO", 3000);
                                           
        System.out.println(this.registro);                                           
    }   
    
    public static void main(String[] args) throws java.text.ParseException{
        (new App()).run();
    }    
    
}
