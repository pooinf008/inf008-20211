public class Carta{
    

    
    public static final int COPAS = 0;
    public static final int ESPADAS = 1;
    public static final int OURO = 2;
    public static final int PAUS = 3;
    
    private Valor valor;
    private Naipe naipe;
    
    public Carta(Valor valor, Naipe naipe){
        this.valor = valor;
        this.naipe = naipe;
    }
    
    public String toString(){
        return valor.valor() + valor.simbolo() +
               naipe; 
    }    
    
}


