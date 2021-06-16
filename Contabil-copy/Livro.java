public class Livro extends ItemVenda{
    private String id;
    
    public Livro(String id, double valor){
        super(valor);
        this.id = id;
    }
    
    public double getPreco(){
        return super.getPreco() * 0.75;
    } 
    
    public String toString(){
        return "Livro " + this.id + "..... RS" + this.getPreco();
    }    
    
  
    
}