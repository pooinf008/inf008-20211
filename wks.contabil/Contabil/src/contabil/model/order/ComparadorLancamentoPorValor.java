package contabil.model.order;

import contabil.model.entity.Lancamento;

public class ComparadorLancamentoPorValor implements Comparador{
    
    public int comparar(Ordenavel o1, Ordenavel o2){
        if((!(o1 instanceof Lancamento)) ||  (!(o2 instanceof Lancamento)))
            return 0;
        Lancamento l1 = (Lancamento) o1;    
        Lancamento l2 = (Lancamento) o2;
        
        return (int) (l2.getValor() - l1.getValor());
        
    };     
}
