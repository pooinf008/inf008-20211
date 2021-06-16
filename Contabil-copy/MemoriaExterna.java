
public class MemoriaExterna extends ItemVenda{
    public long capacidade;
    public String descricao;
    
    
    public MemoriaExterna(String descricao, long capacidade, double preco){
        super(preco);
        this.descricao = descricao;
        this.capacidade = capacidade;
        
    }
    
    public String toString(){
        return "Memoria " + this.descricao + "(" + this.capacidade + ")..... RS" + this.getPreco();
    }     
}