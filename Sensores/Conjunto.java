public class Conjunto{
    private int[] elementos;
    
    
    public Conjunto(){
        this.elementos = new int[0];
    }   
    
    public Conjunto(int[] elementos){
        this.elementos = elementos;
    }     
    
    public Conjunto(Conjunto outro){
        this.elementos = new int[outro.tamanho()];
        for(int i = 0; i < this.elementos.length; i++)
          this.elementos[i]  = outro.elementos[i];
    }   
    
    
    private void addElemento(int elemento){
        int[] novo = new int[this.elementos.length + 1];
        for(int i = 0; i < this.elementos.length; i++)
          novo[i] = this.elementos[i];
        novo[novo.length - 1] = elemento;
        this.elementos = novo;
    } 
    
    public int tamanho(){
        return this.elementos.length;
    };
        
    
    public void adicionar(int inteiro){
        if(!this.pertence(inteiro))
          this.addElemento(inteiro);
    }    
    
    public boolean pertence(int inteiro){
        for(int elemento : this.elementos)
          if(elemento == inteiro)
            return true;
        return false;    
    }
    
    public Conjunto UNIAO(Conjunto outro){
        Conjunto uniao = new Conjunto(outro);
        for(int elemento : this.elementos)
          if(!uniao.pertence(elemento))
            uniao.adicionar(elemento);
        return uniao;    
    }    
    
    public Conjunto INTER(Conjunto outro){
        Conjunto inter = new Conjunto();
        for(int elemento : this.elementos)
          if(outro.pertence(elemento))
            inter.adicionar(elemento);
        for(int elemento : outro.elementos)
          if(this.pertence(elemento))
            inter.adicionar(elemento);
        return inter;    
    }    
    
}
