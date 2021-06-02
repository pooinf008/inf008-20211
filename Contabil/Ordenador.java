public class Ordenador{
    
    private Ordenavel[] ordenaveis;
    
    public Ordenador(Ordenavel[] ordenaveis){
        this.ordenaveis = ordenaveis;
    }    
    
    public void ordenar(){
        for(int iCont = 0; iCont < this.ordenaveis.length - 1; iCont++)
            for(int jCont = iCont+1; jCont < this.ordenaveis.length ; jCont++)
               if(this.ordenaveis[iCont].compare(this.ordenaveis[jCont]) > 0){
                   Ordenavel aux = this.ordenaveis[iCont];
                   this.ordenaveis[iCont] = this.ordenaveis[jCont];
                   this.ordenaveis[jCont] = aux;
               }   
    }    
}
