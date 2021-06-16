
public class CD extends ItemVenda{
    
    public String banda;
    public String titulo;
    
    
    public CD(String banda, String titulo, double preco){
        super(preco);
        this.banda = banda;
        this.titulo = titulo;
        
    }
    
    public String toString(){
        return "CD " + this.banda + "(" + this.titulo + ")..... RS" + this.getPreco();
    }     
}
