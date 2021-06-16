import java.util.Scanner;

public class Cast{
    
    public void doCast() throws java.io.IOException{

        ContaCorrente[] ccc;
        ccc = new ContaCorrente[5];
        for(int i = 0; i < ccc.length; i++){
            java.util.Random random = new java.util.Random();
            if(random.nextBoolean())
              ccc[i] = new ContaEspecial(0, 1000); //upcast
            else
              ccc[i] =  new ContaCorrente();
        }    
        
        for(int i = 0; i < ccc.length; i++){
            ccc[i].sacar(100);
            System.out.println(ccc[i]);
        }
    }    
}
