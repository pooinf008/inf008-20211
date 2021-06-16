public class CarrinhoCompras{
    
    private ItemVenda[] itens = new ItemVenda[0];
    
    public void addItem(ItemVenda item){
        ItemVenda[] novo = new ItemVenda[this.itens.length + 1];
        for(int i = 0; i < this.itens.length; i++)
          novo[i] = this.itens[i];
        novo[novo.length - 1] = item;
        this.itens = novo;
    }    
    
    public double getPreco(){
        double preco = 0;
        for(ItemVenda item : this.itens)
          preco+= item.getPreco();
        return preco;  
    } 
    
    public String toString(){
        String rep = "";
        for(ItemVenda item : this.itens)
          rep = rep + item + "\n";
        rep += getPreco();
        return rep;
    }    
}
