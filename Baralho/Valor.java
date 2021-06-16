public enum Valor{
    AS(1, "A"),
    DOIS(2, "2"),
    TRES(3, "3"),
    DEZ(10, "10"),
    VALETE(11, "J"),
    DAMAS(12, "Q"),
    REI(13, "K");
    
    
    private int valor;
    private String simbolo;
    
    Valor(int valor, String simbolo){
        this.valor = valor;
        this.simbolo = simbolo;
    }  
    
    public int valor(){
        return this.valor;
    }     
    
    public String simbolo(){
        return this.simbolo;
    }         
}
