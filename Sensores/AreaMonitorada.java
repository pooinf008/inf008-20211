public class AreaMonitorada{
    
    private NoSensor[] nos;
    
    public AreaMonitorada(){
        this.nos = new NoSensor[0];
    };
    
    public void adicionarNo(NoSensor novo){
        NoSensor[] novosNos = new NoSensor[this.nos.length + 1]; 
        for(int iCont = 0; iCont < this.nos.length; iCont++)
            novosNos[iCont] = this.nos[iCont]; 
        novosNos[novosNos.length - 1] = novo;
        this.nos = novosNos;
    };   
    
    
    public String toString(){
        String rep = "";
        for(NoSensor no : this.nos)
            rep = rep + no + "\n";
        return rep;    
    }   
    
    
    public void lerTemperatura(){
        java.util.Random random = new java.util.Random();
        
        for(NoSensor no : this.nos)
            no.setTemperatura(random.nextInt(45) * random.nextDouble());
    }  
    
    public double getMaiorTemperatura(){
        double maiorTemperatura = this.nos[0].getTemperatura();
        for(NoSensor no : this.nos)
           if(no.getTemperatura() > maiorTemperatura) 
             maiorTemperatura = no.getTemperatura();
        return maiorTemperatura;    
    } 
    
    public double getMaiorTemperatura(double maxAltitude){
        double maiorTemperatura = 0; 
        int iCont;
        for(iCont = 0; iCont < this.nos.length; iCont++)
           if(this.nos[iCont].getAltura() < maxAltitude){ 
             maiorTemperatura = this.nos[iCont].getTemperatura();
             break;
           } 
        
        for(; iCont < this.nos.length; iCont++)
            if(this.nos[iCont].getAltura() < maxAltitude &&
               this.nos[iCont].getTemperatura() > maiorTemperatura)
             maiorTemperatura = this.nos[iCont].getTemperatura();
        return maiorTemperatura;    
    } 

    public double getMenorTemperatura(double maxAltitude){
        double menorTemperatura = 0; 
        int iCont;
        for(iCont = 0; iCont < this.nos.length; iCont++)
           if(this.nos[iCont].getAltura() < maxAltitude){ 
             menorTemperatura = this.nos[iCont].getTemperatura();
             break;
           } 
        
        for(; iCont < this.nos.length; iCont++)
            if(this.nos[iCont].getAltura() < maxAltitude &&
               this.nos[iCont].getTemperatura() < menorTemperatura)
             menorTemperatura = this.nos[iCont].getTemperatura();
        return menorTemperatura;    
    }     
    
    
    public double getMenorTemperatura(){
        double menorTemperatura = this.nos[0].getTemperatura();
        for(NoSensor no : this.nos)
           if(no.getTemperatura() < menorTemperatura) 
             menorTemperatura = no.getTemperatura();
        return menorTemperatura;    
    }    
    
    public double getAmplitudeTermica(){
        return this.getMaiorTemperatura() - this.getMenorTemperatura();
    } 
    
    public double getAmplitudeTermica(double maxAltitude){
        return this.getMaiorTemperatura(maxAltitude) - 
               this.getMenorTemperatura(maxAltitude);
    } 
    
    private NoSensor[] getMaisDistantes(){
        NoSensor[] nosDistantes = new NoSensor[2];
        nosDistantes[0] = nosDistantes[1] = this.nos[0];
        for(int iCont = 0; iCont < this.nos.length - 1; iCont++)
          for(int jCont = iCont + 1; jCont < this.nos.length; jCont++)
            if(nosDistantes[0].getDistancia(nosDistantes[1]) < 
               this.nos[iCont].getDistancia(this.nos[jCont])){
                   nosDistantes[0] = this.nos[iCont];
                   nosDistantes[1] = this.nos[jCont];
                }  
        return nosDistantes;
    }  
    
    public double getAmplitudeEntreMaisDistantes(){
        NoSensor[] distantes = this.getMaisDistantes();
        return Math.abs(distantes[0].getTemperatura() - distantes[1].getTemperatura());
    }    
    
    public double getDistanciaEntreMaisDistantes(){
        NoSensor[] distantes = this.getMaisDistantes();
        return distantes[0].getDistancia(distantes[1]);
    }    
    
    
        
    
    
    
}
