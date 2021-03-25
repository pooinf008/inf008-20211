public class Programa{
    private AreaMonitorada area = new AreaMonitorada();
    
    public void popular(int qtdeNos){
        
        java.util.Random random = new java.util.Random();
        
        for(int iCont = 0; iCont < qtdeNos; iCont++){ 
            NoSensor no = new NoSensor("NO_" + iCont, 
                                        random.nextInt(50), 
                                        random.nextInt(50),
                                        random.nextInt(50));
            this.area.adicionarNo(no);
        }
        
        System.out.println(this.area);
    } 
    
    
    public void lerTemperatura(){
        this.area.lerTemperatura();
        System.out.println(this.area);
        System.out.println("Amplitude Termica: " + this.area.getAmplitudeTermica() + "°C");
        System.out.println("Amplitude Termica (Mais Distantes): " + this.area.getAmplitudeEntreMaisDistantes() + "°C");
        System.out.println("Distancia (Mais Distantes): " + this.area.getDistanciaEntreMaisDistantes()+ "m");
    } 
    
    public void lerTemperatura(double maxAltura){
        this.area.lerTemperatura();
        System.out.println(this.area);
        System.out.println("Amplitude Termica: " + this.area.getAmplitudeTermica(maxAltura) + "°C");
    } 
    
    
   
    
}
