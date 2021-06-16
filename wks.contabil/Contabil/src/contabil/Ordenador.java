package contabil;
public class Ordenador{
    
    public Ordenador(){
    }    
    
    public void ordenar(Ordenavel[] ordenaveis){
        for(int iCont = 0; iCont < ordenaveis.length - 1; iCont++)
            for(int jCont = iCont+1; jCont < ordenaveis.length ; jCont++)
               if(ordenaveis[iCont].compare(ordenaveis[jCont]) > 0){
                   Ordenavel aux = ordenaveis[iCont];
                   ordenaveis[iCont] = ordenaveis[jCont];
                   ordenaveis[jCont] = aux;
               }   
    } 
    
    public void ordenar(Ordenavel[] ordenaveis, Comparador comparador){
        for(int iCont = 0; iCont < ordenaveis.length - 1; iCont++)
            for(int jCont = iCont+1; jCont < ordenaveis.length ; jCont++)
               if(comparador.comparar(ordenaveis[iCont], ordenaveis[jCont]) > 0){
                   Ordenavel aux = ordenaveis[iCont];
                   ordenaveis[iCont] = ordenaveis[jCont];
                   ordenaveis[jCont] = aux;
               }   
    }    
    
}
