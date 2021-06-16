public class App{
    
    public void doShop(){
        
        CarrinhoCompras carrinho = new CarrinhoCompras();
        carrinho.addItem(new Livro("O MITO DA DEM", 10));
        carrinho.addItem(new Livro("O MUNDO DE SOFI", 40));
        carrinho.addItem(new Livro("A ERA DAS REVOLUCOES", 60));
        carrinho.addItem(new CD("...AJFA", "METALLICA", 30));
        carrinho.addItem(new MemoriaExterna("SD", 1048, 30));
        

        System.out.println(carrinho);
        
    }  
    
    public static void main(String[] args){
        App app = new App();
        app.doShop();
    }    
    
        
        
    
    
}
