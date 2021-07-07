package contabil.model;

import java.io.IOException;
import java.text.ParseException;

import contabil.model.entity.Ativo;
import contabil.model.entity.Conta;
import contabil.model.entity.Lancamento;
import contabil.model.entity.Passivo;
import contabil.model.entity.PatrLiquido;
import contabil.model.exception.ContaInexistenteException;
import contabil.model.exception.ContabilException;
import contabil.model.order.Ordenador;
import contabil.model.order.Ordenavel;

public class App{
    
    private static final int  ATIVO = 1;
    private static final int  PASSIVO = 2;
    private static final int  PATR_LIQUIDO = 3;
    
    private AppRegistroContabil registro;
        
    
    public App() throws Exception{
        this.registro = new AppRegistroContabil();
    }    
    
/*    
    public void dummy(){
        Ordenavel[] ordenaveis = new Ordenavel[8];
        ordenaveis[0] = new Ativo("C", "AtivoC", 10);
        ordenaveis[1] = new Lancamento(new java.util.Date(), 
                                       "Lancamento1",
                                        (Conta)ordenaveis[0], 
                                        (Conta)ordenaveis[0],
                                        10);
        ordenaveis[2] = new Lancamento(new java.util.Date(), 
                                       "Lancamento2",
                                        (Conta)ordenaveis[0], 
                                        (Conta)ordenaveis[0],
                                        10);
        ordenaveis[3] = new Ativo("E", "AtivoE", 20);
        ordenaveis[4] = new PatrLiquido("A", "PatrLiqA", 50);
        ordenaveis[5] = new PatrLiquido("G", "PatrLiqG", 1);
        ordenaveis[6] = new Passivo("B", "PassivoB", 3);
        ordenaveis[7] = new Lancamento(new java.util.Date(), 
                                       "Lancamento3",
                                        (Conta)ordenaveis[0], 
                                        (Conta)ordenaveis[0],
                                        10);
        new Ordenador().ordenar(ordenaveis);
        
        for(Ordenavel o : ordenaveis)
           System.out.println(o);
        
    }*/    
        
    
    
    public void run() throws Exception{
//        this.registro.addConta("1.3", "IMOVEIS", App.ATIVO);
//        this.registro.addConta("1.1","CAIXA", App.ATIVO);
//        this.registro.addConta("3.1", "CAPITAL", App.PATR_LIQUIDO);
//        this.registro.addConta("2.1", "EMPRESTIMO", App.PASSIVO);
        try {
			this.registro.registarFatoContabil("01/02/2021",  "Compra da Sede",
			                                   "IMOVEIS", "CAIXA", 2000);
			this.registro.registarFatoContabil("01/01/2021", "Integralizacao",
			                                   "CAIXA", "CAPITAL", 5000);
			this.registro.registarFatoContabil("01/03/2021", "Tomada de Emprestimo Bco XXX",
			                                   "CAIXA", "EMPRESTIMO", 3000);
		} catch (ContaInexistenteException | ParseException e) {
			throw new ContabilException(e);
		}finally {
			
		}
        
        System.out.println(this.registro);                                   
        System.out.println("***********************************");    
        System.out.println("***********************************");                                           
        System.out.println(this.registro.getRelatorioPorValor());
                                                           
    }   
    
    
    public void lancadorExcecao() {
    	Conta c = null;
    	c.creditar(100);
    }
    
    public static void main(String[] args) throws Exception{
        try {
			(new App()).run();
		} catch (ContabilException e) {
			e.printStackTrace();
		}
    }    
    
}
