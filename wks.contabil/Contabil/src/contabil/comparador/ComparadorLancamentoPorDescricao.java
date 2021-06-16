package contabil.comparador;

import contabil.Comparador;
import contabil.Lancamento;
import contabil.Ordenavel;

public class ComparadorLancamentoPorDescricao implements Comparador{
    
    public int comparar(Ordenavel o1, Ordenavel o2){
        if((!(o1 instanceof Lancamento)) ||  (!(o2 instanceof Lancamento)))
            return 0;
        Lancamento l1 = (Lancamento) o1;    
        Lancamento l2 = (Lancamento) o2;
        
        return l1.getDescricao().compareToIgnoreCase(l2.getDescricao());
        
    };     

}
