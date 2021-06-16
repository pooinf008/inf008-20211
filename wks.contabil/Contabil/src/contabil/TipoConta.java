package contabil;
public enum TipoConta{
    
    Ativo(1), Passivo(2), PatrLiquido(3);
    
    private int codTipo;
    
    TipoConta(int codTipo){
        this.codTipo = codTipo;
    }  
    
    public int value(){
        return codTipo;
    }    
}
